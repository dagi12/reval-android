package pl.edu.amu.wmi.reval.task;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.task.filter.TaskRequestParameters;
import pl.edu.amu.wmi.reval.task.page.AbstractTaskPageActivity;
import pl.edu.amu.wmi.reval.task.page.AdminTaskPageActivity;

public class AddTaskActivity extends RevalActivity implements TaskServiceImpl.AddTaskAdapter {

    @BindView(R.id.task_content)
    EditText taskContent;

    @Inject
    TaskServiceImpl taskService;
    private SubjectTopicContainer container;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        setContentView(R.layout.activity_add_task);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        container = new SubjectTopicContainer(this, this);
    }

    @OnClick(R.id.add_task)
    public void onClick() {
        TaskRequestParameters parameters = container.getParameters();
        if (parameters != null) {
            String taskContentText = taskContent.getText().toString();
            if (TextUtils.isEmpty(taskContentText)) {
                taskContent.setError(getString(R.string.write_task_conent));
            } else {
                progressDialog.setMessage(getString(R.string.add_task));
                progressDialog.show();
                taskService.addTask(this,
                        new Task(parameters, getString(R.string.task_content)));
            }
        }
    }

    @Override
    public void success(Task task) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Intent intent = new Intent(this, AdminTaskPageActivity.class)
                .putExtra(AbstractTaskPageActivity.TASK_PARAM, task);
        finish();
        startActivity(intent);
    }
}
