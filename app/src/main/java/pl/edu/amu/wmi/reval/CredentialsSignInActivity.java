package pl.edu.amu.wmi.reval;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.task.TaskActivity;
import pl.edu.amu.wmi.reval.user.LoginCallback;

/**
 * A login screen that offers login via email/password.
 */
public class CredentialsSignInActivity extends AppCompatActivity implements LoginCallback {

    @BindView(R.id.email)
    EditText mEmailView;

    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.login_progress)
    View mProgressView;

    @BindView(R.id.login_form)
    View mLoginFormView;
    private boolean loginInProgress = false;

    @OnEditorAction(R.id.password)
    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
        if (id == R.id.login || id == EditorInfo.IME_NULL) {
            onSignInEmailClick();
            return true;
        }
        return false;
    }

    @OnClick(R.id.email_sign_in_button)
    public void onSignInEmailClick() {
        if (loginInProgress) {
            return;
        }
        if (verify()) {
            loginInProgress = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        setContentView(R.layout.activity_credentials_login);
    }

    public boolean verify() {
        mEmailView.setError(null);
        mPasswordView.setError(null);
        if (TextUtils.isEmpty(mEmailView.getText().toString())) {
            mEmailView.setError(getString(R.string.empty_index));
            return false;
        }
        if (TextUtils.isEmpty(mPasswordView.getText().toString())) {
            mPasswordView.setError(getString(R.string.empty_password));
            return false;
        }
        if (mPasswordView.getText().toString().length() < 6) {
            mPasswordView.setError(getString(R.string.short_password));
            return false;
        }
        return true;
    }

    @Override
    public void onSuccess() {
        loginInProgress = false;
        startActivity(new Intent(this, TaskActivity.class));
    }

    @Override
    public void onFailure() {
        startActivity(new Intent(this, TaskActivity.class));
        loginInProgress = false;
    }

}

