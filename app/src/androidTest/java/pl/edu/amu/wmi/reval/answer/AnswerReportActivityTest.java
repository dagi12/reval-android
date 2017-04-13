package pl.edu.amu.wmi.reval.answer;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.Serializable;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.StubData;
import pl.edu.amu.wmi.reval.answer.basic.BasicAnswerActivity;
import pl.edu.amu.wmi.reval.answer.report.AnswerReportActivity;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AnswerReportActivityTest {

    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<BasicAnswerActivity>(BasicAnswerActivity.class, false, false) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = super.getActivityIntent();
            intent.putExtra(AnswerReportActivity.CHECKED_ANSWERS_PARAM, (Serializable) StubData.stubAnswers());
            return intent;
        }
    };

    @Test
    public void simple() {
        activityRule.launchActivity(null);
        onView(withId(R.id.actionbar_text_view)).perform(click());
    }
}
