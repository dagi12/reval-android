package pl.edu.amu.wmi.reval.answer.holder;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import pl.edu.amu.wmi.reval.R;

public class FragmentAnswerViewHolder extends AbstractAnswerViewHolder {

    @BindView(R.id.index)
    TextView index;

    public FragmentAnswerViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setRow() {
        super.setRow();
        index.setText(item.getUser());
    }
}
