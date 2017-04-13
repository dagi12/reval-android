package pl.edu.amu.wmi.reval.common.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.util.DaggerUtil;
import pl.edu.amu.wmi.reval.di.MyApplicationComponent;
import pl.edu.amu.wmi.reval.user.activity.SignInActivity;
import pl.edu.amu.wmi.reval.user.service.UserContext;

public class RevalActivity extends AppCompatActivity {

    @Inject
    protected UserContext userContext;
    protected ProgressDialog progressDialog;

    protected void setActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setCustomView(R.layout.action_bar);
        } else {
            throw new NullPointerException("Action bar is null");
        }
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
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public MyApplicationComponent getComponent() {
        return DaggerUtil.getComponent(this);
    }

}
