package pl.edu.amu.wmi.reval.task;

import android.os.Bundle;

import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class AddTaskActivity extends RevalActivity {

    private SubjectTopicContainer container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);
        container = new SubjectTopicContainer(this, this);
    }
}
