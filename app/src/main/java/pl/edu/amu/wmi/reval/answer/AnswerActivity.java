package pl.edu.amu.wmi.reval.answer;

import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.exception.NoParamException;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class AnswerActivity extends RevalActivity implements AnswerServiceImpl.AnswerAdapter {

    public static final String CHECKED_ANSWERS_PARAM = "CHECKED_ANSWERS_PARAM";
    public static final String QUESTION_PARAM = "QUESTION_PARAM";
    @Inject
    AnswerServiceImpl answerService;
    private AnswerFragment answerFragment;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        MyApplication.getComponent().inject(this);
        answerFragment = (AnswerFragment) getFragmentManager().findFragmentById(R.id.answer_fragment);
        initProgressDialog(R.string.answer_progress);
        initExtra();
    }

    @SuppressWarnings("unchecked")
    private void initExtra() {
        int id = getIntent().getIntExtra(QUESTION_PARAM, -1);
        if (id > -1) {
            progressDialog.show();
            answerService.getAnswersByQuestionId(this, id);
        } else {
            List<Answer> answers = (List<Answer>) getIntent().getSerializableExtra(CHECKED_ANSWERS_PARAM);
            if (answers != null) {
                answerFragment.setData(answers);
            } else {
                throw new NoParamException();
            }
        }
    }


    @Override
    public void setAnswers(List<Answer> answers) {
        answerFragment.setData(answers);
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
