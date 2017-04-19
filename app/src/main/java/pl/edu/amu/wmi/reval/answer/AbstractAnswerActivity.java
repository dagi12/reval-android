package pl.edu.amu.wmi.reval.answer;

import android.content.Intent;

import java.io.Serializable;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.answer.page.AdminAnswerPageActivity;
import pl.edu.amu.wmi.reval.answer.page.StudentAnswerPageActivity;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.grid.AbstractFragmentGrid;
import pl.edu.amu.wmi.reval.common.grid.OnListFragmentInteractionListener;

public abstract class AbstractAnswerActivity<T extends Answer & Serializable> extends RevalActivity implements OnListFragmentInteractionListener<T> {

    private static final int RATE_ANSWER_CODE = 163;
    @Inject
    protected AnswerServiceImpl answerService;
    protected AbstractFragmentGrid<T, ?> fragmentGrid;

    protected abstract void initExtra();

    @SuppressWarnings("unchecked")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RATE_ANSWER_CODE &&
                resultCode == AdminAnswerPageActivity.SUCCESS_CODE) {
            Object answer = data.getSerializableExtra(AdminAnswerPageActivity.ANSWER_PARAM);
            if (answer != null) {
                fragmentGrid.update((T) answer);
            }
        }
    }

    protected void fragmentInteraction(Answer item) {
        if (userContext.getUser().isAdmin()) {
            startActivityForResult(new Intent(this, AdminAnswerPageActivity.class)
                    .putExtra(AdminAnswerPageActivity.ANSWER_PARAM, item), RATE_ANSWER_CODE);
        } else {
            startActivity(new Intent(this, StudentAnswerPageActivity.class)
                    .putExtra(AdminAnswerPageActivity.ANSWER_PARAM, item));
        }
    }

}
