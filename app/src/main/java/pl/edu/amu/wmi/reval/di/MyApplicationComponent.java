package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.amu.wmi.reval.CredentialsSignInActivity;
import pl.edu.amu.wmi.reval.answer.AnswerActivity;
import pl.edu.amu.wmi.reval.answer.page.AdminAnswerPageActivity;
import pl.edu.amu.wmi.reval.answer.page.StudentAnswerPageActivity;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.common.services.MyCallback;
import pl.edu.amu.wmi.reval.question.AddQuestionActivity;
import pl.edu.amu.wmi.reval.question.QuestionActivity;
import pl.edu.amu.wmi.reval.question.QuestionFragment;
import pl.edu.amu.wmi.reval.question.filter.QuestionFilterDialogFragment;
import pl.edu.amu.wmi.reval.question.page.AdminQuestionPageActivity;
import pl.edu.amu.wmi.reval.question.page.StudentQuestionPageActivity;
import pl.edu.amu.wmi.reval.question.unique.CheckUniqueActivity;


@Singleton
@Component(modules = {MyApplicationModule.class})
public interface MyApplicationComponent {
    void inject(CredentialsSignInActivity credentialsSignInActivity);

    void inject(QuestionActivity questionActivity);

    void inject(AdminQuestionPageActivity adminQuestionPageActivity);

    void inject(QuestionFragment questionFragment);

    void inject(MyCallback.MyCallbackInjectHelper myCallbackInjectHelper);

    void inject(QuestionFilterDialogFragment questionFilterDialogFragment);

    void inject(CheckUniqueActivity checkUniqueActivity);

    void inject(SubjectTopicContainer subjectTopicContainer);

    void inject(AddQuestionActivity addQuestionActivity);

    void inject(AdminAnswerPageActivity adminAnswerPageActivity);

    void inject(StudentQuestionPageActivity studentQuestionPageActivity);

    void inject(StudentAnswerPageActivity studentAnswerPageActivity);

    void inject(AnswerActivity answerActivity);
}
