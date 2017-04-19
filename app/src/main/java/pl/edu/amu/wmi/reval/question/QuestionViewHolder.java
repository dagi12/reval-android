package pl.edu.amu.wmi.reval.question;

import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public class QuestionViewHolder extends AbstractViewHolder<Question> {

    @BindView(R.id.subject_name)
    TextView subjectName;

    @BindView(R.id.topic_name)
    TextView topicName;

    @BindView(R.id.question_text)
    TextView questionText;

    @BindView(R.id.question_date)
    TextView questionDate;

    public QuestionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setRow() {
        subjectName.setText(item.getSubjectName());
        topicName.setText(item.getTopicName());
        questionText.setText(item.getQuestionText());
        if (item.getLastActivityDate() != null) {
            questionDate.setText(DateFormat.getDateInstance().format(item.getLastActivityDate()));
        }
    }
}
