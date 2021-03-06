package pl.edu.amu.wmi.reval.answer.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public abstract class AbstractAnswerViewHolder extends AbstractViewHolder<Answer> {

    @BindView(R.id.question_text)
    TextView questionTitle;

    @BindView(R.id.answer_date)
    TextView answerDate;

    AbstractAnswerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setRow() {
        if (item.getQuestion() != null && !TextUtils.isEmpty(item.getQuestion().getQuestionText())) {
            questionTitle.setText(item.getQuestion().getQuestionText());
        }
        if (item.getPubDate() != null) {
            answerDate.setText(DateFormat.getDateInstance().format(item.getPubDate()));
        }
    }
}