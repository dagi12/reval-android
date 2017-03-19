package pl.edu.amu.wmi.reval.question.unique;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.answer.AnswerActivity;
import pl.edu.amu.wmi.reval.answer.AnswerServiceImpl;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class CheckUniqueActivity extends RevalActivity implements AnswerServiceImpl.AnswerAdapter {

    private AnswerServiceImpl answerService;

    private SubjectTopicContainer container;

    @OnClick(R.id.check_unique)
    public void onClick() {
        answerService.checkUnique(this, container.getParameters().getTopicId());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_unique);
        ButterKnife.bind(this);
        MyApplication.getComponent().inject(this);
        container = new SubjectTopicContainer(this, this);
    }

    @Override
    public void setAnswers(List<Answer> answers) {
        startActivity(new Intent(this, AnswerActivity.class).putExtra(AnswerActivity.CHECKED_ANSWERS_PARAM, (Serializable) answers));
    }
}
