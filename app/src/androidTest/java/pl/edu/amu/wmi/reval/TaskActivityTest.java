package pl.edu.amu.wmi.reval;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;
import pl.edu.amu.wmi.reval.task.TaskActivity;
import pl.edu.amu.wmi.reval.task.TaskService;
import pl.edu.amu.wmi.reval.user.UserContext;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TaskActivityTest {


    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(TaskActivity.class, false, false);

    @Mock
    UserContext userContext;

    @Mock
    TaskService taskServiceImpl;

    @Test
    public void clickSignIn() {
        when(userContext.getUser()).thenReturn(MockData.mockedUser());
        activityRule.launchActivity(null);
//        onView(withId(R.id.add_task)).perform(click());
    }

}
