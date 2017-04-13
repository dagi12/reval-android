package pl.edu.amu.wmi.reval.user.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.util.DaggerUtil;
import pl.edu.amu.wmi.reval.question.QuestionActivity;
import pl.edu.amu.wmi.reval.user.model.Credentials;
import pl.edu.amu.wmi.reval.user.service.UserServiceImpl;

/**
 * A login screen that offers login via index/password.
 */
public class CredentialsSignInActivity extends Activity implements UserServiceImpl.SignInAdapter {

    static final String ADMIN_MODE = "ADMIN";

    @BindView(R.id.index)
    EditText loginView;

    @BindView(R.id.password)
    EditText passwordView;

    @BindView(R.id.login_form)
    View loginFormView;

    @BindView(R.id.error_message)
    TextView errorMessage;

    Animation shakeAnimation;

    @Inject
    UserServiceImpl userService;

    private boolean loginInProgress = false;
    private boolean firstErrorAttempt = true;
    private ProgressDialog progressDialog;

    @OnEditorAction(R.id.password)
    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
        if (id == R.id.login || id == EditorInfo.IME_NULL) {
            onSignInClick();
            return true;
        }
        return false;
    }

    @OnClick(R.id.sign_in_button)
    public void onSignInClick() {
        if (!loginInProgress && verify()) {
            loginInProgress = true;
            progressDialog.show();
            userService.signIn(this, new Credentials(
                    loginView.getText().toString(),
                    passwordView.getText().toString(),
                    getIntent().getBooleanExtra(ADMIN_MODE, false)
            ));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerUtil.getComponent(this).inject(this);
        setContentView(R.layout.activity_credentials_sign_in);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.sign_progress));
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake_animation);
        if (getIntent().getBooleanExtra(ADMIN_MODE, false)) {
            loginView.setHint(R.string.prompt_index);
        }
    }

    public boolean verify() {
        loginView.setError(null);
        passwordView.setError(null);
        if (TextUtils.isEmpty(loginView.getText().toString())) {
            loginView.setError(getString(R.string.empty_index));
            return false;
        }
        if (TextUtils.isEmpty(passwordView.getText().toString())) {
            passwordView.setError(getString(R.string.empty_password));
            return false;
        }
        if (passwordView.getText().toString().length() < 8) {
            passwordView.setError(getString(R.string.short_password));
            return false;
        }
        return true;
    }

    @Override
    public void onSignInSuccess() {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onSignInCommon() {
        loginInProgress = false;
        progressDialog.dismiss();
    }

    @Override
    public void onSignInFailure() {
        loginInProgress = false;
        if (firstErrorAttempt) {
            errorMessage.setVisibility(View.VISIBLE);
            firstErrorAttempt = false;
        } else {
            errorMessage.startAnimation(shakeAnimation);
        }
    }
}
