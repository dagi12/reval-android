package pl.edu.amu.wmi.reval.question.page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.exception.PageItemNullException;
import pl.edu.amu.wmi.reval.question.Question;
import pl.edu.amu.wmi.reval.question.QuestionViewHolder;

public abstract class AbstractQuestionPageActivity extends RevalActivity {

    public static final String QUESTION_PARAM = "QUESTION";
    protected Question question;

    @BindView(R.id.answer_button)
    protected Button answerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);
        ButterKnife.bind(this);
        setItem();
    }

    private void setItem() {
        question = (Question) getIntent().getSerializableExtra(QUESTION_PARAM);
        if (question == null) {
            throw new PageItemNullException();
        }
        QuestionPageViewHolder holder =
                new QuestionPageViewHolder(findViewById(android.R.id.content));
        holder.setItem(question);
        holder.setRow();
    }

    @OnClick(R.id.answer_button)
    public void onClick() {
        answerClick();
    }

    abstract void answerClick();

    class QuestionPageViewHolder extends QuestionViewHolder {
//        @BindView(R.id.question_content)
//        TextView questionContent;

        public QuestionPageViewHolder(View itemView) {
            super(itemView);
//            ButterKnife.bind(itemView);
        }

        @Override
        public void setRow() {
            super.setRow();
//            questionContent.setText(item.getQuestionText());
        }
    }

}
