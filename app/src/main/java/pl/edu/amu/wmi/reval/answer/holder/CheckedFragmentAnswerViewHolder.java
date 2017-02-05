package pl.edu.amu.wmi.reval.answer.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import pl.edu.amu.wmi.reval.R;

public class CheckedFragmentAnswerViewHolder extends FragmentAnswerViewHolder {

    @BindView(R.id.similarity)
    TextView similarity;

    public CheckedFragmentAnswerViewHolder(View view) {
        super(view);
    }

    @Override
    public void setRow() {
        super.setRow();
        similarity.setText(item.getSimilarity());
    }
}

