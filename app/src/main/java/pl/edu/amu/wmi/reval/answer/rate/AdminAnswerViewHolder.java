package pl.edu.amu.wmi.reval.answer.rate;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.holder.FragmentAnswerViewHolder;

public class AdminAnswerViewHolder extends FragmentAnswerViewHolder {

    @BindView(R.id.answer_content)
    TextView answerContent;

    public AdminAnswerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setRow() {
        super.setRow();
        answerContent.setText(item.getAnswerText());
    }

}
