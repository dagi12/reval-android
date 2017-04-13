package pl.edu.amu.wmi.reval.answer.basic;

import android.os.Bundle;

import java.util.List;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.AbstractAnswerActivity;
import pl.edu.amu.wmi.reval.answer.AnswerServiceImpl;
import pl.edu.amu.wmi.reval.common.exception.NoParamException;

public class BasicAnswerActivity extends AbstractAnswerActivity<Answer> implements AnswerServiceImpl.AnswerAdapter {

    public static final String QUESTION_PARAM = "QUESTION_PARAM";
    private BasicAnswerFragment basicAnswerFragment;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        getComponent().inject(this);
        basicAnswerFragment = (BasicAnswerFragment) getFragmentManager().findFragmentById(R.id.answer_fragment);
        initProgressDialog(R.string.answer_progress);
        initExtra();
    }

    @Override
    protected void initExtra() {
        int id = getIntent().getIntExtra(QUESTION_PARAM, -1);
        if (id > -1) {
            progressDialog.show();
            answerService.getAnswersByQuestionId(this, id);
        } else {
            throw new NoParamException();
        }
    }


    @Override
    public void setAnswers(List<Answer> answers) {
        basicAnswerFragment.setData(answers);
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onListFragmentInteraction(Answer item) {
        fragmentInteraction(item);
    }


}
