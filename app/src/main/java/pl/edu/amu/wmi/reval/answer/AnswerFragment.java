package pl.edu.amu.wmi.reval.answer;

import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

import butterknife.BindView;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractFragmentGrid;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;

public class AnswerFragment extends AbstractFragmentGrid<Answer, AnswerFragment.AnswerViewHolder> {

    public static AnswerFragment getInstance(List<Answer> answers) {
        AnswerFragment fragment = new CheckedAnswerFragment();
        fragment.setData(answers);
        return fragment;
    }

    public static AnswerFragment getInstance() {
        return new AnswerFragment();
    }

    @Override
    protected int getListWrapperId() {
        return R.layout.fragment_answer_list;
    }

    @Override
    public AnswerViewHolder createViewHolder(View view) {
        return new AnswerViewHolder(view);
    }

    @Override
    public int getItemViewId() {
        return R.layout.fragment_answer;
    }

    public class AnswerViewHolder extends AbstractViewHolder<Answer> {

        @BindView(R.id.subject_name)
        TextView subjectName;

        @BindView(R.id.task_name)
        TextView taskName;

        @BindView(R.id.answer_date)
        TextView answerDate;

        AnswerViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setRow() {
            subjectName.setText(item.getSubjectName());
            taskName.setText(item.getTaskName());
            answerDate.setText(DateFormat.getDateInstance().format(item.getDate()));
        }
    }
}
