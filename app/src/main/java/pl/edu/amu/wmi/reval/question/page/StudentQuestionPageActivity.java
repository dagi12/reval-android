package pl.edu.amu.wmi.reval.question.page;

import android.content.Intent;
import android.os.Bundle;

import pl.edu.amu.wmi.reval.answer.page.StudentAnswerPageActivity;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class StudentQuestionPageActivity extends AbstractQuestionPageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
    }

    @Override
    void answerClick() {
        startActivity(new Intent(this, StudentAnswerPageActivity.class)
                .putExtra(StudentAnswerPageActivity.ANSWER_PARAM, question.getAnswer()));
    }
}
