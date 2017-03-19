package pl.edu.amu.wmi.reval.question;

import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public class QuestionViewHolder extends AbstractViewHolder<Question> {

    @BindView(R.id.subject_name)
    TextView subjectName;

    @BindView(R.id.topic_name)
    TextView topicName;

    @BindView(R.id.question_title)
    TextView questionTitle;

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
        questionTitle.setText(item.getQuestionTitle());
        // todo do usunięcia gdy data ostatnie aktywności na API
        if (item.getLastActivityDate() == null) {
            item.setLastActivityDate(new Date());
            questionDate.setText(DateFormat.getDateInstance().format(item.getLastActivityDate()));
        }
    }
}
