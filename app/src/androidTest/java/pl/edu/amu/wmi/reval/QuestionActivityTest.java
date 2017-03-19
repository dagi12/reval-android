package pl.edu.amu.wmi.reval;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;
import pl.edu.amu.wmi.reval.question.QuestionActivity;
import pl.edu.amu.wmi.reval.question.QuestionService;
import pl.edu.amu.wmi.reval.user.UserContext;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.when;

public class QuestionActivityTest {


    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<QuestionActivity>(QuestionActivity.class, false, false);

    @Mock
    UserContext userContext;

    @Mock
    QuestionService questionServiceImpl;

    @Test
    public void clickFilter() {
        when(userContext.getUser()).thenReturn(MockData.mockedAdmin());
        activityRule.launchActivity(null);
        onView(withId(R.id.question_filter_button)).perform(click());
        onView(withId(R.id.search_question)).perform(click());
    }

    @Test
    public void checkStudentNav() {
        when(userContext.getUser()).thenReturn(MockData.mockedStudent());
        activityRule.launchActivity(null);
        onView(withContentDescription(getString(R.string.navigation_drawer_open))).perform(click());
        onView(withId(R.id.user_role)).perform(click());
    }

    @Test
    public void checkAdminNav() {
        when(userContext.getUser()).thenReturn(MockData.mockedAdmin());
        activityRule.launchActivity(null);
        onView(withContentDescription(getString(R.string.navigation_drawer_open))).perform(click());
        onView(withId(R.id.admin_logo)).perform(click());
    }

    private String getString(@StringRes int resId) {
        return getInstrumentation().getTargetContext().getString(resId);
    }

}
