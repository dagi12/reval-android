package pl.edu.amu.wmi.reval.question.nav;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.grid.AbstractViewHolder;
import pl.edu.amu.wmi.reval.user.model.User;

public class HeaderViewHolder extends AbstractViewHolder<User> {

    @BindView(R.id.user_name)
    TextView userName;
    @Nullable
    @BindView(R.id.index)
    TextView index;

    public HeaderViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    @Override
    public void setRow() {
        userName.setText(item.getFullName());
        if (index != null) {
            index.setText(item.getIndex());
        }
    }


}
