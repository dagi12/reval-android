package pl.edu.amu.wmi.reval.answer;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import pl.edu.amu.wmi.reval.R;

public class CheckedAnswerFragment extends AnswerFragment {

    @Override
    public AnswerViewHolder createViewHolder(View view) {
        return new CheckedAnswerViewHolder(view);
    }

    @Override
    public int getItemViewId() {
        return R.layout.fragment_checked_answer;
    }

    class CheckedAnswerViewHolder extends AnswerViewHolder {

        @BindView(R.id.similarity)
        TextView similarity;

        CheckedAnswerViewHolder(View view) {
            super(view);
        }

        @Override
        public void setRow() {
            super.setRow();
            similarity.setText(item.getSimilarity());
        }
    }
}
