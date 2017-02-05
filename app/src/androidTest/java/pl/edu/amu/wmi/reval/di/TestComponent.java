package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.amu.wmi.reval.TaskActivityTest;

@Singleton
@Component(modules = TestModule.class)
public interface TestComponent extends MyApplicationComponent {

    void inject(TaskActivityTest taskActivityTest);
}
