package pl.edu.amu.wmi.reval.answer.page;

import android.os.Bundle;

import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.answer.holder.AbstractAnswerViewHolder;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.exception.PageItemNullException;

public abstract class AbstractAnswerPageActivity extends RevalActivity {

    public static final String ANSWER = "ANSWER";
    protected Answer answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setItem();
    }

    private void setItem() {
        answer = (Answer) getIntent().getSerializableExtra(ANSWER);
        if (answer == null) {
            throw new PageItemNullException();
        }
        AbstractAnswerViewHolder holder = getHolder();
        holder.setItem(answer);
        holder.setRow();
    }

    abstract AbstractAnswerViewHolder getHolder();


}
