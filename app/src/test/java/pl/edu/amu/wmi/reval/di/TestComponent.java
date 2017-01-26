package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestModule.class)
public interface TestComponent {
    void inject(AbstractDaggerServiceTest abstractDaggerServiceTest);
}
