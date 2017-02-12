package pl.edu.amu.wmi.reval.answer.page;

import android.content.Intent;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.edu.amu.wmi.reval.MockData;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class StudentAnswerPageActivityTest {


    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<StudentAnswerPageActivity>(StudentAnswerPageActivity.class, false, false) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = super.getActivityIntent();
            intent.putExtra(AbstractAnswerPageActivity.ANSWER_PARAM, MockData.mockedAnswer());
            return intent;
        }
    };

    @Test
    public void simple() {
        activityRule.launchActivity(null);
        onView(withId(R.id.actionbar_text_view)).perform(click());
    }

    @Test
    public void homeButton() {
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
    }
}
