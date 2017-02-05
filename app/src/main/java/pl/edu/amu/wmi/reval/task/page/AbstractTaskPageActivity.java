package pl.edu.amu.wmi.reval.task.page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.exception.PageItemNullException;
import pl.edu.amu.wmi.reval.task.Task;
import pl.edu.amu.wmi.reval.task.TaskViewHolder;

abstract class AbstractTaskPageActivity extends RevalActivity {

    public static final String TASK_PARAM = "TASK";
    protected Task task;
    @BindView(R.id.answer_button)
    protected Button answerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_page);
        setItem();
    }

    private void setItem() {
        task = (Task) getIntent().getSerializableExtra(TASK_PARAM);
        if (task == null) {
            throw new PageItemNullException();
        }
        TaskPageViewHolder holder =
                new TaskPageViewHolder(findViewById(android.R.id.content));
        holder.setItem(task);
        holder.setRow();
    }

    @OnClick(R.id.answer_button)
    public void onClick() {
        answerClick();
    }

    abstract void answerClick();

    class TaskPageViewHolder extends TaskViewHolder {
        @BindView(R.id.task_content)
        TextView taskContent;

        public TaskPageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        @Override
        public void setRow() {
            super.setRow();
            taskContent.setText(item.getTaskContent());
        }
    }

}
