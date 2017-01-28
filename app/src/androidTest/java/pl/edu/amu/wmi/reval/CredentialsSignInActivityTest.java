package pl.edu.amu.wmi.reval;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CredentialsSignInActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            CredentialsSignInActivity.class);

    @Test
    public void clickIndex() {
        onView(withId(R.id.index)).perform(click());
    }

    @Test
    public void clickPassword() {
        onView(withId(R.id.password)).perform(click());
    }

    @Test
    public void clickSignIn() {
        onView(withId(R.id.sign_in_button)).perform(click());
    }


}
