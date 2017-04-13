package pl.edu.amu.wmi.reval.answer;

import android.content.Intent;

import java.io.Serializable;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.answer.page.AdminAnswerPageActivity;
import pl.edu.amu.wmi.reval.answer.page.StudentAnswerPageActivity;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.common.grid.OnListFragmentInteractionListener;

public abstract class AbstractAnswerActivity<T extends AbstractRevalItem & Serializable> extends RevalActivity implements OnListFragmentInteractionListener<T> {

    @Inject
    protected AnswerServiceImpl answerService;

    protected abstract void initExtra();

    protected void fragmentInteraction(Answer item) {
        if (userContext.getUser().isAdmin()) {
            startActivity(new Intent(this, AdminAnswerPageActivity.class)
                    .putExtra(AdminAnswerPageActivity.ANSWER_PARAM, item));
        } else {
            startActivity(new Intent(this, StudentAnswerPageActivity.class)
                    .putExtra(AdminAnswerPageActivity.ANSWER_PARAM, item));
        }
    }

}
