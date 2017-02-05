package pl.edu.amu.wmi.reval.answer;

import android.os.Bundle;

import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class AnswerPageActivity extends RevalActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_page);
        ButterKnife.bind(this);
        MyApplication.getComponent().inject(this);
    }
}
