package pl.edu.amu.wmi.reval.answer;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.basic.BasicAnswerActivity;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class QuestionBasicAnswerActivityTest {

    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<BasicAnswerActivity>(BasicAnswerActivity.class, false, false) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = super.getActivityIntent();
            intent.putExtra(BasicAnswerActivity.QUESTION_PARAM, 0);
            return intent;
        }
    };

    @Test
    public void simple() {
        activityRule.launchActivity(null);
        onView(withId(R.id.question_title)).perform(click());
    }

    @Test
    public void homeButton() {
        onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());
    }

}
