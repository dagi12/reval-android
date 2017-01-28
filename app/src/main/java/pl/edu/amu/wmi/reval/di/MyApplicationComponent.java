package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.amu.wmi.reval.CredentialsSignInActivity;
import pl.edu.amu.wmi.reval.TaskPageActivity;
import pl.edu.amu.wmi.reval.task.TaskActivity;
import pl.edu.amu.wmi.reval.task.TaskFragment;


@Singleton
@Component(modules = {MyApplicationModule.class})
public interface MyApplicationComponent { 
    void inject(CredentialsSignInActivity credentialsSignInActivity);
    void inject(TaskActivity taskActivity);
    void inject(TaskPageActivity taskPageActivity);
    void inject(TaskFragment taskFragment);
}
