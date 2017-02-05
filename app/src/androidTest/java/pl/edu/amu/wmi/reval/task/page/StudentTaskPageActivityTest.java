package pl.edu.amu.wmi.reval.task.page;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class StudentTaskPageActivityTest {
    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(StudentTaskPageActivity.class, false, false);

    @Test
    public void simple() {
        onView(withId(R.id.actionbar_text_view)).perform(click());
    }
}
