package pl.edu.amu.wmi.reval.question.page;

import android.content.Intent;
import android.os.Bundle;

import pl.edu.amu.wmi.reval.answer.AnswerActivity;

public class AdminQuestionPageActivity extends AbstractQuestionPageActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
    }

    @Override
    void answerClick() {
        startActivity(new Intent(this, AnswerActivity.class).putExtra(AnswerActivity.QUESTION_PARAM, question.getId()));
    }

}
