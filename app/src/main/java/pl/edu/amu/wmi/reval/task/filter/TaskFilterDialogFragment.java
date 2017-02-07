package pl.edu.amu.wmi.reval.task.filter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.common.dialog.MyBottomSheetDialogFragment;
import pl.edu.amu.wmi.reval.common.exception.AdapterLackException;
import pl.edu.amu.wmi.reval.di.MyApplication;


public class TaskFilterDialogFragment extends MyBottomSheetDialogFragment {

    private TaskRequestAdapter adapter;

    private SubjectTopicContainer container;

    public static TaskFilterDialogFragment getInstance() {
        return new TaskFilterDialogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        Context context = getActivity();
        if (context instanceof TaskRequestAdapter) {
            adapter = (TaskRequestAdapter) context;
        } else {
            throw new AdapterLackException(context, TaskRequestAdapter.class);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = new SubjectTopicContainer(getActivity(), getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_filter_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.search_task)
    public void search() {
        TaskRequestParameters parameters = container.getParameters();
        if (parameters != null) {
            adapter.populateFilter(parameters);
            dismiss();
        }
    }

}
