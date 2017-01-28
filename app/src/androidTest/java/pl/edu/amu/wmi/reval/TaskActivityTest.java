package pl.edu.amu.wmi.reval;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.di.DaggerTestComponent;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.di.MyApplicationModule;
import pl.edu.amu.wmi.reval.di.TestComponent;
import pl.edu.amu.wmi.reval.task.TaskActivity;
import pl.edu.amu.wmi.reval.user.UserContext;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TaskActivityTest {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(TaskActivity.class, false, false);

    @Inject
    UserContext userContext;

    private static MyApplication getApp() {
        return (MyApplication) InstrumentationRegistry.getInstrumentation()
                .getTargetContext().getApplicationContext();
    }

    @Before
    public void setUp() {
        TestComponent component =
                DaggerTestComponent.builder()
                        .myApplicationModule(new MyApplicationModule(getApp())).build();
        getApp().setComponent(component);
        component.inject(this);
    }

    @Test
    public void clickSignIn() {
        userContext.setUser(MockData.mockedUser());
        activityRule.launchActivity(null);
        onView(withId(R.id.add_task)).perform(click());
    }

}
