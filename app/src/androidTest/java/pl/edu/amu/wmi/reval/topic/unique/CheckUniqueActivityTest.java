package pl.edu.amu.wmi.reval.topic.unique;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import pl.edu.amu.wmi.reval.di.MyDaggerMockRule;
import pl.edu.amu.wmi.reval.task.unique.CheckUniqueActivity;

@RunWith(AndroidJUnit4.class)
public class CheckUniqueActivityTest {

    @Rule
    public MyDaggerMockRule myDaggerMockRule = new MyDaggerMockRule();

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(CheckUniqueActivity.class, false, false);

}
