package pl.edu.amu.wmi.reval.di;

import javax.annotation.Nullable;
import javax.inject.Inject;

import pl.edu.amu.wmi.reval.user.service.UserContext;
import retrofit2.Retrofit;

public abstract class AbstractDaggerServiceTest {

    @Inject
    public UserContext userContext;

    @Inject
    public Retrofit retrofit;

    protected void setUp() {
        JUnitTestComponent component = DaggerJUnitTestComponent.builder().jUnitTestModule(new JUnitTestModule()).build();
        component.inject(this);
    }

    protected boolean isEmpty(@Nullable String str) {
        return str == null || str.length() == 0;
    }

}
