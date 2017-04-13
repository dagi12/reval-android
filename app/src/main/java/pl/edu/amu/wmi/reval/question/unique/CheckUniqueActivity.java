package pl.edu.amu.wmi.reval.question.unique;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.AnswerServiceImpl;
import pl.edu.amu.wmi.reval.answer.report.AnswerReport;
import pl.edu.amu.wmi.reval.answer.report.AnswerReportActivity;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.topic.Topic;

public class CheckUniqueActivity extends RevalActivity implements AnswerServiceImpl.AnswerReportAdapter {

    @Inject
    AnswerServiceImpl answerService;

    private SubjectTopicContainer container;

    @OnClick(R.id.check_unique)
    public void onClick() {
        Topic topic = container.getParameters();
        progressDialog.show();
        answerService.checkUnique(this, topic.getId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_unique);
        ButterKnife.bind(this);
        getComponent().inject(this);
        container = new SubjectTopicContainer(this, this);
        initProgressDialog(R.string.answer_progress);
    }

    @Override
    public void setAnswerReports(List<AnswerReport> answerReports) {
        startActivity(new Intent(this, AnswerReportActivity.class).putExtra(AnswerReportActivity.CHECKED_ANSWERS_PARAM, (Serializable) answerReports));
        progressDialog.dismiss();
    }
}
