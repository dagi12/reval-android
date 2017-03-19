package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.amu.wmi.reval.QuestionActivityTest;

@Singleton
@Component(modules = TestModule.class)
public interface TestComponent extends MyApplicationComponent {

    void inject(QuestionActivityTest questionActivityTest);
}
