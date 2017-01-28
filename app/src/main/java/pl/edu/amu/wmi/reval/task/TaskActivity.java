package pl.edu.amu.wmi.reval.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.TaskPageActivity;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.exception.HiddenElementException;
import pl.edu.amu.wmi.reval.di.MyApplication;

public class TaskActivity extends RevalActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.add_task)
    FloatingActionButton addButton;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @OnClick(R.id.add_task)
    void onClick(View view) {
        if (!userContext.getUser().isAdmin()) {
            throw new HiddenElementException();
        }
        startActivity(new Intent(this, TaskPageActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        MyApplication.getComponent().inject(this);
        ButterKnife.bind(this);
        setNavigationDrawer();
        if (userContext.getUser().isAdmin()) {
            addButton.setVisibility(View.VISIBLE);
        }
    }

    //todo możliwe że do wyjebania
    private void setNavigationDrawer() {
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.nav_camera) {
//        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
