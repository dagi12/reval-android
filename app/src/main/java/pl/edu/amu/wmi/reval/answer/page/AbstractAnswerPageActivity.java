package pl.edu.amu.wmi.reval.answer.page;

import android.os.Bundle;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.answer.holder.AbstractAnswerViewHolder;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.exception.PageItemNullException;

public abstract class AbstractAnswerPageActivity extends RevalActivity {

    public static final String ANSWER_PARAM = "ANSWER_PARAM";
    protected Answer answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_page);
        setItem();
    }

    private void setItem() {
        answer = (Answer) getIntent().getSerializableExtra(ANSWER_PARAM);
        if (answer == null) {
            throw new PageItemNullException();
        }
        AbstractAnswerViewHolder holder = getHolder();
        holder.setItem(answer);
        holder.setRow();
    }

    abstract AbstractAnswerViewHolder getHolder();

}
