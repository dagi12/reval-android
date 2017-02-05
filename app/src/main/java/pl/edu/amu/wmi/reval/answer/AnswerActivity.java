package pl.edu.amu.wmi.reval.answer;

import android.os.Bundle;

import java.util.List;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;

public class AnswerActivity extends RevalActivity {

    public static final String CHECKED_ANSWERS_PARAM = "CHECKED_ANSWERS_PARAM";
    private AnswerFragment answerFragment;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        List<Answer> answers = (List<Answer>) getIntent().getSerializableExtra(CHECKED_ANSWERS_PARAM);
        if (savedInstanceState == null) {
            if (answers != null) {
                answerFragment = AnswerFragment.getInstance(answers);
            } else {
                answerFragment = AnswerFragment.getInstance();
            }
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.answer_fragment_container, answerFragment)
                    .commit();
        } else {
            answerFragment = (AnswerFragment) getFragmentManager().findFragmentById(R.id.answer_fragment_container);
        }

    }
}
