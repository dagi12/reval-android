package pl.edu.amu.wmi.reval.task.page;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import pl.edu.amu.wmi.reval.MockData;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.AnswerActivity;
import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;
import pl.edu.amu.wmi.reval.user.UserContext;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class AdminTaskPageActivityTest {

    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<AdminTaskPageActivity>(AdminTaskPageActivity.class, false, false) {
        @Override
        protected Intent getActivityIntent() {
            Intent intent = super.getActivityIntent();
            intent.putExtra(AdminTaskPageActivity.TASK_PARAM, MockData.mockedTask());
            return intent;
        }
    };

    @Mock
    UserContext userContext;

    @Test
    public void goToAnswers() {
        when(userContext.getUser()).thenReturn(MockData.mockedAdmin());
        activityRule.launchActivity(null);
        onView(withId(R.id.answer_button)).perform(click());
        intended(hasComponent(AnswerActivity.class.getName()));
    }
}
