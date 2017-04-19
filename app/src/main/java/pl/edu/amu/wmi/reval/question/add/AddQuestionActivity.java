package pl.edu.amu.wmi.reval.question.add;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Spinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.RevalActivity;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.common.spinner.NumberSpinnerAdapter;
import pl.edu.amu.wmi.reval.question.Question;
import pl.edu.amu.wmi.reval.question.QuestionServiceImpl;
import pl.edu.amu.wmi.reval.question.page.AbstractQuestionPageActivity;
import pl.edu.amu.wmi.reval.question.page.AdminQuestionPageActivity;
import pl.edu.amu.wmi.reval.topic.Topic;

public class AddQuestionActivity extends RevalActivity implements AddQuestionAdapter {

    @BindView(R.id.question_content)
    EditText questionContent;

    @BindView(R.id.number_spinner)
    Spinner maxPointsSpinner;

    @Inject
    QuestionServiceImpl questionService;
    private SubjectTopicContainer container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        setContentView(R.layout.activity_add_question);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        container = new SubjectTopicContainer(this, this);
        maxPointsSpinner.setAdapter(new NumberSpinnerAdapter(this, 10));
    }

    @OnClick(R.id.add_question)
    public void onClick() {
        Topic parameters = container.getParameters();
        if (parameters != null) {
            String questionContentText = questionContent.getText().toString();
            if (TextUtils.isEmpty(questionContentText)) {
                questionContent.setError(getString(R.string.write_question_conent));
            } else {
                progressDialog.setMessage(getString(R.string.add_question));
                progressDialog.show();
                int selectedPoints = Integer.parseInt(String.valueOf(maxPointsSpinner.getSelectedItem()));
                questionService.addQuestion(this, new Question(parameters, questionContent.getText().toString(), selectedPoints));
            }
        }
    }

    @Override
    public void success(Question question) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Intent intent = new Intent(this, AdminQuestionPageActivity.class)
                .putExtra(AbstractQuestionPageActivity.QUESTION_PARAM, question);
        finish();
        startActivity(intent);
    }
}
