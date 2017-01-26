package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.amu.wmi.reval.CredentialsSignInActivity;


@Singleton
@Component(modules = {MyApplicationModule.class})
public interface MyApplicationComponent {


    void inject(CredentialsSignInActivity credentialsSignInActivity);
}
