package pl.edu.amu.wmi.reval.task.page;

import android.content.Intent;
import android.os.Bundle;

import pl.edu.amu.wmi.reval.answer.AnswerActivity;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class AdminTaskPageActivity extends AbstractTaskPageActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
    }

    @Override
    void answerClick() {
        startActivity(new Intent(this, AnswerActivity.class).putExtra(AnswerActivity.TASK_PARAM, task.getId()));
    }

}
