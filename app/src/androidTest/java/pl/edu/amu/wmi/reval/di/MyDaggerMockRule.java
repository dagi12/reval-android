//package pl.edu.amu.wmi.reval.di;
//
//import android.support.test.InstrumentationRegistry;
//
//import it.cosenonjaviste.daggermock.DaggerMockRule;
//
//public class MyDaggerMockRule extends DaggerMockRule<MyApplicationComponent> {
//
//    public MyDaggerMockRule() {
//        super(MyApplicationComponent.class, new MyApplicationModule(getApp()));
//        set(new ComponentSetter<MyApplicationComponent>() {
//            @Override
//            public void setComponent(MyApplicationComponent component) {
//                getApp().setComponent(component);
//            }
//        });
//    }
//
//    private static MyApplication getApp() {
//        return (MyApplication) InstrumentationRegistry.getInstrumentation()
//                .getTargetContext().getApplicationContext();
//    }
//
//}
