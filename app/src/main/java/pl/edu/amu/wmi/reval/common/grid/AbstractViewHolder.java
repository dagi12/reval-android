package pl.edu.amu.wmi.reval.common.grid;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder {

    public final View view;
    protected T item;

    public AbstractViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }

    protected static String concat(String leftStr, String rightStr) {
        return leftStr + " " + (TextUtils.isEmpty(rightStr) ? "" : rightStr);
    }

    public void setItem(T item) {
        this.item = item;
    }

    public abstract void setRow();


}
