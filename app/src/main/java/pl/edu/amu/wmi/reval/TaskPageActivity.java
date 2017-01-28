package pl.edu.amu.wmi.reval;

import android.os.Bundle;

import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class TaskPageActivity extends RevalActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_page);
        ButterKnife.bind(this);
        MyApplication.getComponent().inject(this);
    }
}
