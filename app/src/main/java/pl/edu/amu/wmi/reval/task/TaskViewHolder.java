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
        // todo do usunięcia gdy data ostatnie aktywności na API
        if (item.getLastActivityDate() == null) {
            item.setLastActivityDate(new Date());
        }
        taskNameTextView.setText(DateFormat.getDateInstance().format(item.getLastActivityDate()));
    }
}
