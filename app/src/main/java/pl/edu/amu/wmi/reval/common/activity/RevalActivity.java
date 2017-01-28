package pl.edu.amu.wmi.reval.common.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.SignInActivity;
import pl.edu.amu.wmi.reval.user.UserContext;

public class RevalActivity extends AppCompatActivity {

    @Inject
    protected UserContext userContext;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.default_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            userContext.setUser(null);
            startActivity(new Intent(this, SignInActivity.class));
        } else if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
