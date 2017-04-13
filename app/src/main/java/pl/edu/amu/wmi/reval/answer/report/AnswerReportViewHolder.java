package pl.edu.amu.wmi.reval.answer.report;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.holder.FragmentAnswerViewHolder;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public class AnswerReportViewHolder extends AbstractViewHolder<AnswerReport> {

    @BindView(R.id.similarity)
    TextView similarity;

    private FragmentAnswerViewHolder answerViewHolder;

    AnswerReportViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
        answerViewHolder = new FragmentAnswerViewHolder(view);
    }

    @Override
    public void setRow() {
        answerViewHolder.setItem(item.getAnswer());
        answerViewHolder.setRow();
        similarity.setText(concat(Integer.toString(item.getSimilarity()), "%"));
    }

}

