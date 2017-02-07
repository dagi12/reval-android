package pl.edu.amu.wmi.reval.answer.page;

import android.os.Bundle;

import pl.edu.amu.wmi.reval.answer.holder.AbstractAnswerViewHolder;
import pl.edu.amu.wmi.reval.answer.holder.AdminAnswerViewHolder;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class AdminAnswerPageActivity extends AbstractAnswerPageActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
    }

    @Override
    AbstractAnswerViewHolder getHolder() {
        return new AdminAnswerViewHolder(findViewById(android.R.id.content));
    }

}
