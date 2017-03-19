package pl.edu.amu.wmi.reval.question.page;

import android.content.Intent;
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
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class StudentQuestionPageActivityTest {
    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<StudentQuestionPageActivity>(StudentQuestionPageActivity.class, false, false) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = super.getActivityIntent();
            intent.putExtra(AbstractQuestionPageActivity.QUESTION_PARAM, MockData.mockedQuestion());
            return intent;
        }
    };

    @Test
    public void simple() {
        activityRule.launchActivity(null);
        onView(withId(R.id.actionbar_text_view)).perform(click());
    }
}
