package pl.edu.amu.wmi.reval.task;

import android.view.View;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractFragmentGrid;

public class TaskFragment extends AbstractFragmentGrid<Task, TaskViewHolder> {

    @Override
    protected int getListWrapperId() {
        return R.layout.fragment_task_list;
    }

    @Override
    public TaskViewHolder createViewHolder(View view) {
        return new TaskViewHolder(view);
    }

    @Override
    public int getItemViewId() {
        return R.layout.fragment_task;
    }


}
