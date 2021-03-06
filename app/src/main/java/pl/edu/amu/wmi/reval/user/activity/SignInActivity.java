package pl.edu.amu.wmi.reval.user.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;

public class SignInActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.admin_login_button)
    void onAdminLoginButtonClick() {
        startActivity(new Intent(this, CredentialsSignInActivity.class)
                .putExtra(CredentialsSignInActivity.ADMIN_MODE, true));
    }

    @OnClick(R.id.student_login_button)
    void onStudentLoginButtonClick() {
        startActivity(new Intent(this, CredentialsSignInActivity.class));
    }

}
