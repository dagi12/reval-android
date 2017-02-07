package pl.edu.amu.wmi.reval.common.activity;

import android.app.Activity;

import butterknife.ButterKnife;

public abstract class PageViewHolder<T> {

    protected T item;

    public PageViewHolder(T item, Activity activity) {
        this.item = item;
        ButterKnife.bind(this, activity);
    }

    public abstract void setRow();


}
