package pl.edu.amu.wmi.reval.di;

import org.junit.Before;

import javax.inject.Inject;

import retrofit2.Retrofit;

public abstract class AbstractDaggerServiceTest {


    @Inject
    public Retrofit retrofit;


    @Before
    public void setUp() {
        JUnitTestComponent component = DaggerJUnitTestComponent.builder().jUnitTestModule(new JUnitTestModule()).build();
        component.inject(this);
    }
}
