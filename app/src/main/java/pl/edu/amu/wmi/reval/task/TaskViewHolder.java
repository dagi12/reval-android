package pl.edu.amu.wmi.reval.task;

import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public class TaskViewHolder extends AbstractViewHolder<Task> {

    @BindView(R.id.subject_name)
    TextView subjectNameTextView;

    @BindView(R.id.task_name)
    TextView taskNameTextView;

    public TaskViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setRow() {
        subjectNameTextView.setText(item.getName());
        taskNameTextView.setText(DateFormat.getDateInstance().format(item.getLastActivityDate()));
    }
}
