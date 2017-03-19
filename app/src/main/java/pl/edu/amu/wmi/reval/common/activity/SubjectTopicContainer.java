package pl.edu.amu.wmi.reval.common.activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Spinner;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.dialog.ErrorDialog;
import pl.edu.amu.wmi.reval.common.spinner.MySpinnerAdapter;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.question.filter.QuestionRequestParameters;
import pl.edu.amu.wmi.reval.subject.Subject;
import pl.edu.amu.wmi.reval.subject.SubjectServiceImpl;
import pl.edu.amu.wmi.reval.topic.Topic;
import pl.edu.amu.wmi.reval.topic.TopicServiceImpl;

public class SubjectTopicContainer implements SubjectServiceImpl.SubjectListAdapter, TopicServiceImpl.TopicAdapter {

    private final Context context;
    @Inject
    SubjectServiceImpl subjectService;
    @Inject
    TopicServiceImpl topicService;
    @BindView(R.id.subject_spinner)
    Spinner subjectSpinner;
    @BindView(R.id.topic_spinner)
    Spinner topicSpinner;
    private MySpinnerAdapter<Subject> subjectAdapter;
    private MySpinnerAdapter<Topic> topicAdapter;

    public SubjectTopicContainer(Context context, View view) {
        ButterKnife.bind(this, view);
        this.context = context;
        constuctor();
    }

    public SubjectTopicContainer(Context context, Activity activity) {
        ButterKnife.bind(this, activity);
        this.context = context;
        constuctor();
    }

    private void constuctor() {
        MyApplication.getComponent().inject(this);
        subjectAdapter = new MySpinnerAdapter<>(context);
        topicAdapter = new MySpinnerAdapter<>(context);
        setAdapters();
    }


    private void setAdapters() {
        topicAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        subjectAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);
        topicSpinner.setAdapter(topicAdapter);
        subjectService.getSubjects(this);
        topicService.getTopics(this);
    }

    @Override
    public void populateSubjects(List<Subject> subjects) {
        subjectAdapter.setValues(subjects);
    }

    @Override
    public void populateTopics(List<Topic> topics) {
        topicAdapter.setValues(topics);
    }

    public QuestionRequestParameters getParameters() {
        Subject subject = subjectAdapter.getItem(subjectSpinner.getSelectedItemPosition());
        if (subject == null) {
            ErrorDialog.getInstance(context, context.getString(R.string.select_subject)).show();
            return null;
        }
        QuestionRequestParameters parameters = new QuestionRequestParameters();
        parameters.setSubjectId(subject.getId());
        Topic topic = topicAdapter.getItem(topicSpinner.getSelectedItemPosition());
        if (topic != null) {
            parameters.setTopicId(topic.getId());
            return parameters;
        } else {
            ErrorDialog.getInstance(context, context.getString(R.string.select_topic)).show();
        }
        return null;
    }

}
