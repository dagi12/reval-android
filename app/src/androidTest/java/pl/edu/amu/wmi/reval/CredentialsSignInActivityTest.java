package pl.edu.amu.wmi.reval;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;

import pl.edu.amu.wmi.reval.question.QuestionActivity;
import pl.edu.amu.wmi.reval.user.activity.CredentialsSignInActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CredentialsSignInActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            CredentialsSignInActivity.class);

    @Test
    public void clickIndex() {
        onView(withId(R.id.index)).perform(click());
        onView(withId(R.id.index)).perform(replaceText("Foo"));
        onView(withId(R.id.sign_in_button)).perform(click());
        EditText editText = (EditText) mActivityRule.getActivity().findViewById(R.id.password);
        Assert.assertNotNull(editText.getError());
    }

    @Test
    public void clickPassword() {
        onView(withId(R.id.index)).perform(click());
        onView(withId(R.id.index)).perform(replaceText("Foo"));
        onView(withId(R.id.password)).perform(click());
        onView(withId(R.id.password)).perform(replaceText("FooBa"));
        onView(withId(R.id.sign_in_button)).perform(click());
        EditText editText = (EditText) mActivityRule.getActivity().findViewById(R.id.password);
        Assert.assertNotNull(editText.getError());
    }

    @Test
    public void clickSignIn() {
        Intents.init();
        onView(withId(R.id.index)).perform(replaceText("Foo"));
        onView(withId(R.id.password)).perform(replaceText("FooBar"));
        onView(withId(R.id.sign_in_button)).perform(click());
        intended(hasComponent(QuestionActivity.class.getName()));
    }


}
