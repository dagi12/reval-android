package pl.edu.amu.wmi.reval.question;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;
import pl.edu.amu.wmi.reval.question.page.AdminQuestionPageActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AddQuestionActivityTest {

    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(AddQuestionActivity.class, false, false);

    @Test
    public void simple() {
        activityRule.launchActivity(null);
        onView(withId(R.id.actionbar_text_view)).perform(click());
    }

    @Test
    public void addQuestion() {
        activityRule.launchActivity(null);
        onView(withId(R.id.add_question)).perform(click());
        intended(hasComponent(AdminQuestionPageActivity.class.getName()));
    }

}
