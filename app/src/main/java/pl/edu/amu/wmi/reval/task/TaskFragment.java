package pl.edu.amu.wmi.reval.task;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractFragmentGrid;
import pl.edu.amu.wmi.reval.di.MyApplication;

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

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MyApplication.getComponent().inject(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MyApplication.getComponent().inject(this);
    }
}
