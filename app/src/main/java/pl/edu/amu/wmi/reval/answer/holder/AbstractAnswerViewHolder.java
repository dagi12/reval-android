package pl.edu.amu.wmi.reval.answer.holder;

import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public abstract class AbstractAnswerViewHolder extends AbstractViewHolder<Answer> {

    @BindView(R.id.question_title)
    protected TextView questionTitle;

    @BindView(R.id.answer_date)
    protected TextView answerDate;

    protected AbstractAnswerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setRow() {
        questionTitle.setText(item.getQuestionTitle());
        answerDate.setText(DateFormat.getDateInstance().format(item.getDate()));
    }
}