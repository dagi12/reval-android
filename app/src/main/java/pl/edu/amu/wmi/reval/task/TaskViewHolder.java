package pl.edu.amu.wmi.reval.task;

import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public class TaskViewHolder extends AbstractViewHolder<Task> {

    @BindView(R.id.subject_name)
    TextView subjectName;

    @BindView(R.id.topic_name)
    TextView topicName;

    @BindView(R.id.task_title)
    TextView taskTitle;

    @BindView(R.id.task_date)
    TextView taskDate;

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setRow() {
        subjectName.setText(item.getSubjectName());
        topicName.setText(item.getTopicName());
        taskTitle.setText(item.getTaskTitle());
        // todo do usunięcia gdy data ostatnie aktywności na API
        if (item.getLastActivityDate() == null) {
            item.setLastActivityDate(new Date());
            taskDate.setText(DateFormat.getDateInstance().format(item.getLastActivityDate()));
        }
    }
}
