package pl.edu.amu.wmi.reval.question;

import android.view.View;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractFragmentGrid;

public class QuestionFragment extends AbstractFragmentGrid<Question, QuestionViewHolder> {

    @Override
    protected int getListWrapperId() {
        return R.layout.fragment_question_list;
    }

    @Override
    public QuestionViewHolder createViewHolder(View view) {
        return new QuestionViewHolder(view);
    }

    @Override
    public int getItemViewId() {
        return R.layout.fragment_question;
    }


}
