package pl.edu.amu.wmi.reval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.task.TaskActivity;

public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.admin_login_button)
    void onAdminLoginButtonClick() {
        startActivity(new Intent(this, TaskActivity.class));
    }

    @OnClick(R.id.student_login_button)
    void onStudentLoginButtonClick() {
        startActivity(new Intent(this, TaskActivity.class));
    }

}
