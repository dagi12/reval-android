package pl.edu.amu.wmi.reval.di;

import android.app.Application;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.edu.amu.wmi.reval.StubData;
import pl.edu.amu.wmi.reval.answer.AnswerServiceImpl;
import pl.edu.amu.wmi.reval.common.error.ErrorServiceImpl;
import pl.edu.amu.wmi.reval.question.QuestionServiceImpl;
import pl.edu.amu.wmi.reval.subject.SubjectServiceImpl;
import pl.edu.amu.wmi.reval.topic.TopicServiceImpl;
import pl.edu.amu.wmi.reval.user.model.Credentials;
import pl.edu.amu.wmi.reval.user.service.UserContext;
import pl.edu.amu.wmi.reval.user.service.UserServiceImpl;

@Module
public class TestModule {

    private final Application mApplication;

    public TestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    protected UserContext provideUserContext() {
        return Mockito.mock(UserContext.class);
    }

    @Provides
    @Singleton
    protected UserServiceImpl provideUserService(UserContext userContext) {
        return new UserServiceImpl(null, userContext) {
            @Override
            public void signIn(SignInAdapter adapter, Credentials credentials) {
                adapter.onSignInSuccess();
            }
        };
    }

    @Provides
    @Singleton
    protected ErrorServiceImpl provideErrorService() {
        return new ErrorServiceImpl(null, null);
    }

    @Provides
    @Singleton
    protected SubjectServiceImpl provideSubjectServiceImpl() {
        return new SubjectServiceImpl(null) {
            @Override
            public void getSubjects(SubjectListAdapter adapter) {
                adapter.populateSubjects(StubData.stubSubjects());
            }
        };
    }

    @Provides
    @Singleton
    protected QuestionServiceImpl provideQuestionService() {
        return new QuestionServiceImpl(null) {
            @Override
            public void getFilteredQuestions(QuestionAdapter adapter, int topicId) {
                adapter.setQuestions(StubData.stubQuestions());
            }

            @Override
            public void getQuestions(final QuestionAdapter questionAdapter) {
                questionAdapter.setQuestions(StubData.stubQuestions());
            }
        };
    }

    @Provides
    @Singleton
    protected TopicServiceImpl provideTopicService() {
        return new TopicServiceImpl(null) {
            @Override
            public void getTopics(TopicAdapter adapter, int subjectId) {
                adapter.populateTopics(StubData.stubTopics());
            }
        };
    }

    @Provides
    @Singleton
    protected AnswerServiceImpl provideAnswerService() {
        return new AnswerServiceImpl(null);
    }

}


