package pl.edu.amu.wmi.reval.answer;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class AnswerPageActivityTest {

    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(AnswerPageActivity.class, false, false);

    @Test
    public void simple() {
        onView(withId(R.id.actionbar_text_view)).perform(click());
    }
}
