package pl.edu.amu.wmi.reval.di;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {MyApplicationModule.class})
public interface MyApplicationComponent {


}
