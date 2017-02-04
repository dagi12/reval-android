package pl.edu.amu.wmi.reval.task.filter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.dialog.ErrorDialog;
import pl.edu.amu.wmi.reval.common.dialog.MyBottomSheetDialogFragment;
import pl.edu.amu.wmi.reval.common.exception.AdapterLackException;
import pl.edu.amu.wmi.reval.common.spinner.MySpinnerAdapter;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.subject.Subject;
import pl.edu.amu.wmi.reval.subject.SubjectServiceImpl;
import pl.edu.amu.wmi.reval.topic.Topic;
import pl.edu.amu.wmi.reval.topic.TopicServiceImpl;


public class TaskFilterDialogFragment extends MyBottomSheetDialogFragment implements SubjectServiceImpl.SubjectListAdapter, TopicServiceImpl.TopicAdapter {

    @BindView(R.id.topic_spinner)
    Spinner topicSpinner;
    @BindView(R.id.subject_spinner)
    Spinner subjectSpinner;
    @Inject
    SubjectServiceImpl subjectService;
    @Inject
    TopicServiceImpl topicService;
    private MySpinnerAdapter<Subject> subjectAdapter;
    private MySpinnerAdapter<Topic> topicAdapter;
    private TaskRequestAdapter adapter;

    public static TaskFilterDialogFragment getInstance() {
        return new TaskFilterDialogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        Context context = getActivity();
        subjectAdapter = new MySpinnerAdapter<>(context);
        topicAdapter = new MySpinnerAdapter<>(context);
        if (context instanceof TaskRequestAdapter) {
            adapter = (TaskRequestAdapter) context;
        } else {
            throw new AdapterLackException(context, TaskRequestAdapter.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_filter_dialog, container, false);
        ButterKnife.bind(this, view);
        setAdapters();
        return view;
    }

    private void setAdapters() {
        topicAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        subjectAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);
        topicSpinner.setAdapter(topicAdapter);
        subjectService.getSubjects(this);
        topicService.getTopics(this);
    }

    @OnClick(R.id.search_task)
    public void search() {
        Subject subject = subjectAdapter.getItem(subjectSpinner.getSelectedItemPosition());
        if (subject == null) {
            ErrorDialog.getInstance(getActivity(), getString(R.string.select_subject)).show();
            return;
        }
        TaskRequestParameters parameters = new TaskRequestParameters();
        parameters.setSubjectId(subject.getId());
        Topic topic = topicAdapter.getItem(topicSpinner.getSelectedItemPosition());
        if (topic != null) {
            parameters.setTopicId(topic.getId());
        }
        adapter.populateFilter(parameters);
        dismiss();
    }


    @Override
    public void populateSubjects(List<Subject> subjects) {
        subjectAdapter.setValues(subjects);
    }

    @Override
    public void populateTopics(List<Topic> topics) {
        topicAdapter.setValues(topics);
    }
}
