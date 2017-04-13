package pl.edu.amu.wmi.reval.question.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.AnswerServiceImpl;
import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.answer.page.StudentAnswerPageActivity;

public class StudentQuestionPageActivity extends AbstractQuestionPageActivity implements AnswerServiceImpl.StudentAnswerAdapter {

    @Inject
    AnswerServiceImpl answerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        if (question.getAnswered()) {
            answerButton.setText(R.string.your_answer);
            answerButton.setVisibility(View.VISIBLE);
            initProgressDialog(R.string.answer_progress);
        }
    }

    @Override
    void answerClick() {
        progressDialog.show();
        answerService.getAnswerByStudent(this, question.getId());

    }

    @Override
    public void setAnswer(Answer answer) {
        startActivity(new Intent(this, StudentAnswerPageActivity.class)
                .putExtra(StudentAnswerPageActivity.ANSWER_PARAM, answer));
    }

}
