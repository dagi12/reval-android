package pl.edu.amu.wmi.reval.answer.report;

import android.view.View;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractFragmentGrid;

public class AnswerReportFragment extends AbstractFragmentGrid<AnswerReport, AnswerReportViewHolder> {

    @Override
    protected int getListWrapperId() {
        return R.layout.fragment_answer_report_list;
    }

    @Override
    public int getItemViewId() {
        return R.layout.fragment_answer_report;
    }

    @Override
    public AnswerReportViewHolder createViewHolder(View view) {
        return new AnswerReportViewHolder(view);
    }

}
