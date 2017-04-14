package pl.edu.amu.wmi.reval.question;

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
import pl.edu.amu.wmi.reval.question.add.AddQuestionActivity;
import pl.edu.amu.wmi.reval.question.filter.QuestionFilterDialogFragment;
import pl.edu.amu.wmi.reval.question.filter.QuestionRequestAdapter;
import pl.edu.amu.wmi.reval.question.nav.HeaderViewHolder;
import pl.edu.amu.wmi.reval.question.nav.NavigationAdapter;
import pl.edu.amu.wmi.reval.question.page.AdminQuestionPageActivity;
import pl.edu.amu.wmi.reval.question.page.StudentQuestionPageActivity;
import pl.edu.amu.wmi.reval.question.unique.CheckUniqueActivity;
import pl.edu.amu.wmi.reval.topic.Topic;

public class QuestionActivity extends RevalActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        QuestionServiceImpl.QuestionAdapter,
        OnListFragmentInteractionListener<Question>,
        QuestionRequestAdapter {

    private static final String TAG = QuestionActivity.class.getName();
    @Inject
    QuestionServiceImpl questionService;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    private QuestionFragment questionFragment;
    private NavigationAdapter navigationAdapter;
    private QuestionFilterDialogFragment questionFilterDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        if (userContext.isSignedIn()) {
            initActivity();
        } else {
            userContext.hardLogout();
        }
    }

    private void initActivity() {
        setContentView(R.layout.activity_question);
        ButterKnife.bind(this);
        setUserData();
        setNavigationView();
        initProgressDialog(R.string.question_progress);
        questionFragment = (QuestionFragment) getFragmentManager().findFragmentById(R.id.question_fragment);
        questionService.getQuestions(this);
        questionFilterDialog = QuestionFilterDialogFragment.getInstance();
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
            menu.findItem(R.id.add_question).setVisible(false);
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
    public void setQuestions(List<Question> questions) {
        questionFragment.setData(questions);
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onListFragmentInteraction(Question item) {
        if (userContext.getUser().isAdmin()) {
            startActivity(new Intent(this, AdminQuestionPageActivity.class)
                    .putExtra(AdminQuestionPageActivity.QUESTION_PARAM, item));
        } else {
            startActivity(new Intent(this, StudentQuestionPageActivity.class)
                    .putExtra(StudentQuestionPageActivity.QUESTION_PARAM, item));
        }
    }

    @OnClick(R.id.question_filter_button)
    void questionFilterOnClick() {
        questionFilterDialog.show(getSupportFragmentManager(), TAG);
    }


    @Override
    public void populateFilter(Topic parameters) {
        if (parameters.getId() != null) {
            progressDialog.show();
            questionService.getFilteredQuestions(this, parameters.getId());
        }

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
            if (id == R.id.add_question) {
                startActivity(new Intent(context, AddQuestionActivity.class));
            } else if (id == R.id.check_unique) {
                startActivity(new Intent(context, CheckUniqueActivity.class));
            }
        }
    }
}
