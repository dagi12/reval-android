package pl.edu.amu.wmi.reval.answer;

import android.view.View;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.holder.FragmentAnswerViewHolder;
import pl.edu.amu.wmi.reval.common.grid.AbstractFragmentGrid;

public class AnswerFragment extends AbstractFragmentGrid<Answer, FragmentAnswerViewHolder> {

    public static AnswerFragment getInstance() {
        return new AnswerFragment();
    }

    @Override
    protected int getListWrapperId() {
        return R.layout.fragment_answer_list;
    }

    @Override
    public FragmentAnswerViewHolder createViewHolder(View view) {
        return new FragmentAnswerViewHolder(view);
    }

    @Override
    public int getItemViewId() {
        return R.layout.fragment_answer;
    }


}
