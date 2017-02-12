package pl.edu.amu.wmi.reval.task;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;
import pl.edu.amu.wmi.reval.task.page.AdminTaskPageActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AddTaskActivityTest {

    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(AddTaskActivity.class, false, false);

    @Test
    public void simple() {
        activityRule.launchActivity(null);
        onView(withId(R.id.actionbar_text_view)).perform(click());
    }

    @Test
    public void addTask() {
        activityRule.launchActivity(null);
        onView(withId(R.id.add_task)).perform(click());
        intended(hasComponent(AdminTaskPageActivity.class.getName()));
    }

}
