package pl.edu.amu.wmi.reval.question.page;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.page.StudentAnswerPageActivity;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class StudentQuestionPageActivity extends AbstractQuestionPageActivity {

    @BindView(R.id.answer_button)
    Button answerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        answerButton.setText(R.string.your_answer);
    }

    @Override
    void answerClick() {
        startActivity(new Intent(this, StudentAnswerPageActivity.class)
                .putExtra(StudentAnswerPageActivity.ANSWER_PARAM, question.getAnswer()));
    }
}
