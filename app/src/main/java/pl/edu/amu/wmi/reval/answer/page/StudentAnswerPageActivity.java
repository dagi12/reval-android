package pl.edu.amu.wmi.reval.answer.page;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.holder.AbstractAnswerViewHolder;
import pl.edu.amu.wmi.reval.answer.holder.StudentAnswerViewHolder;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class StudentAnswerPageActivity extends AbstractAnswerPageActivity {

    public static final String ANSWER_PARAM = "ANSWER_PARAM";

    @BindView(R.id.index_container)
    View indexContainer;

    @BindView(R.id.question)
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        ButterKnife.bind(this);
        indexContainer.setVisibility(View.GONE);
        question.setText(getString(R.string.your_answer));
    }


    @Override
    AbstractAnswerViewHolder getHolder() {
        return new StudentAnswerViewHolder(findViewById(android.R.id.content));
    }

}
