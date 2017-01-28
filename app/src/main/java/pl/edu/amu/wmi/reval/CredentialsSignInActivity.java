package pl.edu.amu.wmi.reval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.task.TaskActivity;
import pl.edu.amu.wmi.reval.user.UserServiceImpl;

/**
 * A login screen that offers login via index/password.
 */
public class CredentialsSignInActivity extends Activity implements UserServiceImpl.SignInAdapter {

    static final String ADMIN_MODE = "ADMIN";

    @BindView(R.id.index)
    EditText loginView;

    @BindView(R.id.password)
    EditText passwordView;

    @BindView(R.id.login_progress)
    View progressView;

    @BindView(R.id.login_form)
    View loginFormView;

    @BindView(R.id.error_message)
    TextView errorMessage;

    @Inject
    UserServiceImpl userService;

    private boolean loginInProgress = false;

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
        if (loginInProgress) {
            return;
        }
        if (verify()) {
            loginInProgress = true;
            userService.signIn(this, getIntent().getBooleanExtra(ADMIN_MODE, false));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        setContentView(R.layout.activity_credentials_sign_in);
        ButterKnife.bind(this);
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
        if (passwordView.getText().toString().length() < 6) {
            passwordView.setError(getString(R.string.short_password));
            return false;
        }
        return true;
    }

    @Override
    public void onSignInSuccess() {
        loginInProgress = false;
        startActivity(new Intent(this, TaskActivity.class));
    }

    @Override
    public void onSignInFailure() {
        loginInProgress =   false;
        errorMessage.setVisibility(View.VISIBLE);
    }
}

