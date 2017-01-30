package pl.edu.amu.wmi.reval.di;

import android.support.test.InstrumentationRegistry;

import it.cosenonjaviste.daggermock.DaggerMockRule;

public class MyDaggerMockRule extends DaggerMockRule<TestComponent> {

    public MyDaggerMockRule() {
        super(TestComponent.class, new TestModule(getApp()));
        set(new ComponentSetter<TestComponent>() {
            @Override
            public void setComponent(TestComponent component) {
                getApp().setComponent(component);
            }
        });
    }

    private static MyApplication getApp() {
        return (MyApplication) InstrumentationRegistry.getInstrumentation()
                .getTargetContext().getApplicationContext();
    }

}
