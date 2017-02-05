package pl.edu.amu.wmi.reval.answer.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;

public class StudentAnswerViewHolder extends AbstractAnswerViewHolder {

    @BindView(R.id.answer_content)
    TextView answerContent;

    public StudentAnswerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setRow() {
        super.setRow();
        answerContent.setText(item.getAnswerContent());
    }
}
