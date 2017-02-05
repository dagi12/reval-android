package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.amu.wmi.reval.CredentialsSignInActivity;
import pl.edu.amu.wmi.reval.answer.AnswerPageActivity;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.common.services.MyCallback;
import pl.edu.amu.wmi.reval.task.AddTaskActivity;
import pl.edu.amu.wmi.reval.task.TaskActivity;
import pl.edu.amu.wmi.reval.task.TaskFragment;
import pl.edu.amu.wmi.reval.task.filter.TaskFilterDialogFragment;
import pl.edu.amu.wmi.reval.task.page.AdminTaskPageActivity;
import pl.edu.amu.wmi.reval.task.unique.CheckUniqueActivity;


@Singleton
@Component(modules = {MyApplicationModule.class})
public interface MyApplicationComponent {
    void inject(CredentialsSignInActivity credentialsSignInActivity);

    void inject(TaskActivity taskActivity);

    void inject(AdminTaskPageActivity adminTaskPageActivity);

    void inject(TaskFragment taskFragment);

    void inject(MyCallback.MyCallbackInjectHelper myCallbackInjectHelper);

    void inject(TaskFilterDialogFragment taskFilterDialogFragment);

    void inject(CheckUniqueActivity checkUniqueActivity);

    void inject(SubjectTopicContainer subjectTopicContainer);

    void inject(AddTaskActivity addTaskActivity);

    void inject(AnswerPageActivity answerPageActivity);

}
