package pl.edu.amu.wmi.reval.question.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pl.edu.amu.wmi.reval.answer.basic.BasicAnswerActivity;

public class AdminQuestionPageActivity extends AbstractQuestionPageActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        answerButton.setVisibility(View.VISIBLE);
        getComponent().inject(this);
    }

    @Override
    void answerClick() {
        startActivity(new Intent(this, BasicAnswerActivity.class)
                .putExtra(BasicAnswerActivity.QUESTION_PARAM, question.getId()));
    }

}
