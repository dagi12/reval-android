package pl.edu.amu.wmi.reval.answer.report;

import android.os.Bundle;

import java.util.List;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.AbstractAnswerActivity;
import pl.edu.amu.wmi.reval.common.exception.NoParamException;
import pl.edu.amu.wmi.reval.common.grid.EmptyGridDialogFragment;
import pl.edu.amu.wmi.reval.common.util.ListUtils;

public class AnswerReportActivity extends AbstractAnswerActivity<AnswerReport> {

    public static final String CHECKED_ANSWERS_PARAM = "CHECKED_ANSWERS_PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_report);
        getComponent().inject(this);
        fragmentGrid = (AnswerReportFragment) getFragmentManager().findFragmentById(R.id.answer_report_fragment);
        initExtra();
    }

    @Override
    public void onListFragmentInteraction(AnswerReport item) {
        fragmentInteraction(item);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void initExtra() {
        List<AnswerReport> answersReport = (List<AnswerReport>) getIntent().getSerializableExtra(CHECKED_ANSWERS_PARAM);
        if (answersReport == null) {
            throw new NoParamException();
        } else if (ListUtils.isEmpty(answersReport)) {
            EmptyGridDialogFragment.getInstance().show(getFragmentManager(), "dialog");
        } else {
            fragmentGrid.setData(answersReport);
        }
    }

}
