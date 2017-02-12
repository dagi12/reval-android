package pl.edu.amu.wmi.reval.task;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.grid.OnListFragmentInteractionListener;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.task.filter.TaskFilterDialogFragment;
import pl.edu.amu.wmi.reval.task.filter.TaskRequestAdapter;
import pl.edu.amu.wmi.reval.task.filter.TaskRequestParameters;
import pl.edu.amu.wmi.reval.task.nav.HeaderViewHolder;
import pl.edu.amu.wmi.reval.task.nav.NavigationAdapter;
import pl.edu.amu.wmi.reval.task.page.AdminTaskPageActivity;
import pl.edu.amu.wmi.reval.task.unique.CheckUniqueActivity;

public class TaskActivity extends RevalActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        TaskServiceImpl.TaskAdapter,
        OnListFragmentInteractionListener<Task>,
        TaskRequestAdapter {

    private static final String TAG = TaskActivity.class.getName();
    @Inject
    TaskServiceImpl taskService;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    private TaskFragment taskFragment;
    private NavigationAdapter navigationAdapter;
    private TaskFilterDialogFragment taskFilterDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        MyApplication.getComponent().inject(this);
        ButterKnife.bind(this);
        setUserData();
        setNavigationView();
        initProgressDialog(R.string.task_progress);
        taskFragment = (TaskFragment) getFragmentManager().findFragmentById(R.id.task_fragment);
        taskService.getTasks(this);
        taskFilterDialog = TaskFilterDialogFragment.getInstance();
    }

    private void setUserData() {

        if (userContext.getUser().isAdmin()) {
            navigationView.inflateHeaderView(R.layout.nav_header_admin);
            navigationAdapter = new AdminNavigationAdapter(this);
        } else {
            navigationView.inflateHeaderView(R.layout.nav_header_student);
        }
        HeaderViewHolder holder =
                new HeaderViewHolder(navigationView.getHeaderView(0));
        if (!userContext.getUser().isAdmin()) {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.add_task).setVisible(false);
            menu.findItem(R.id.check_unique).setVisible(false);
        }
        holder.setItem(userContext.getUser());
        holder.setRow();
    }

    @Override
    protected void setActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        } else {
            throw new ActionBarException();
        }
    }

    private void setNavigationView() {
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
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
        if (navigationAdapter != null) {
            int id = item.getItemId();
            navigationAdapter.handleMenuItem(id);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setTasks(List<Task> tasks) {
        taskFragment.setData(tasks);
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onListFragmentInteraction(Task item) {
        startActivity(new Intent(this, AdminTaskPageActivity.class).putExtra(AdminTaskPageActivity.TASK_PARAM, item));
    }

    @OnClick(R.id.task_filter_button)
    void taskFilterOnClick() {
        taskFilterDialog.show(getSupportFragmentManager(), TAG);
    }


    @Override
    public void populateFilter(TaskRequestParameters parameters) {
        progressDialog.show();
        taskService.getFilteredTasks(this, parameters);
    }

    private class ActionBarException extends RuntimeException {
        private static final String MESSAGE = "Support action bar is null";

        ActionBarException() {
            super(MESSAGE);
        }
    }

    private class AdminNavigationAdapter implements NavigationAdapter {

        private final Context context;

        AdminNavigationAdapter(Context context) {
            this.context = context;
        }

        @Override
        public void handleMenuItem(int id) {
            if (id == R.id.add_task) {
                startActivity(new Intent(context, AddTaskActivity.class));
            } else if (id == R.id.check_unique) {
                startActivity(new Intent(context, CheckUniqueActivity.class));
            }
        }
    }
}
