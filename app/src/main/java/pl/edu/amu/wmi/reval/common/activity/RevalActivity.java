package pl.edu.amu.wmi.reval.common.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.SignInActivity;
import pl.edu.amu.wmi.reval.user.UserContext;

public class RevalActivity extends AppCompatActivity {

    @Inject
    protected UserContext userContext;
    protected ProgressDialog progressDialog;

    protected void setActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        if (!TextUtils.isEmpty(getTitle())) {
            TextView title = (TextView) findViewById(R.id.actionbar_text_view);
            title.setText(getTitle());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.default_menu, menu);
        setActionBar();
        return true;
    }

    protected void initProgressDialog(@StringRes int stringId) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(stringId));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            userContext.hardLogout();
            startActivity(new Intent(this, SignInActivity.class));
        } else if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
