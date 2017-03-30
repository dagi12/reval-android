package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.amu.wmi.reval.QuestionActivityTest;
import pl.edu.amu.wmi.reval.user.activity.CredentialsSignInActivity;

@Singleton
@Component(modules = TestModule.class)
public interface TestComponent extends MyApplicationComponent {

    void inject(QuestionActivityTest questionActivityTest);

    void inject(CredentialsSignInActivity credentialsSignInActivity);
}
