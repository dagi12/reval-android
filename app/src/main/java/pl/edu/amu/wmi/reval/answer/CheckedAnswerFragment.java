package pl.edu.amu.wmi.reval.answer;

import android.view.View;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.holder.CheckedFragmentAnswerViewHolder;

public class CheckedAnswerFragment extends AnswerFragment {

    @Override
    public CheckedFragmentAnswerViewHolder createViewHolder(View view) {
        return new CheckedFragmentAnswerViewHolder(view);
    }

    @Override
    public int getItemViewId() {
        return R.layout.fragment_checked_answer;
    }

}
