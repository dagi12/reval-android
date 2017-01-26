package pl.edu.amu.wmi.reval.di;

import org.junit.Before;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import retrofit2.Retrofit;

public abstract class AbstractDaggerServiceTest {


    @Inject
    public Retrofit retrofit;


    @Before
    public void setUp() {
        TestComponent component = DaggerTestComponent.builder().testModule(new TestModule()).build();
        component.inject(this);
    }
}
