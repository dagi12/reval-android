package pl.edu.amu.wmi.reval.answer.page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.answer.AnswerServiceImpl;
import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.answer.holder.AbstractAnswerViewHolder;
import pl.edu.amu.wmi.reval.answer.rate.AdminAnswerViewHolder;
import pl.edu.amu.wmi.reval.answer.rate.RateAnswerRequest;
import pl.edu.amu.wmi.reval.answer.rate.RateDialogFragment;
import pl.edu.amu.wmi.reval.answer.rate.RateResult;

public class AdminAnswerPageActivity extends AbstractAnswerPageActivity implements AnswerServiceImpl.RateAnswerAdapter, RateDialogFragment.RateResultAdapter {

    private static final String TAG = AdminAnswerPageActivity.class.getName();
    @BindView(R.id.rate_button)
    Button rateButton;
    @Inject
    AnswerServiceImpl answerService;
    private RateDialogFragment rateDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        rateDialogFragment = RateDialogFragment
                .getInstance(getString(R.string.rate_answer));
    }

    @Override
    AbstractAnswerViewHolder getHolder() {
        View view = findViewById(android.R.id.content);
        ButterKnife.bind(this, view);
        rateButton.setVisibility(View.VISIBLE);
        rateSuccess(new RateResult(answer));
        getRateButtonLabel(answer);
        return new AdminAnswerViewHolder(view);
    }

    @OnClick(R.id.rate_button)
    void onRateButtonClick() {
        rateDialogFragment.show(getFragmentManager(), TAG);
    }

    @Override
    public void processVote(float rate) {
        RateAnswerRequest request = new RateAnswerRequest(answer.getId(), (int) rate);
        answerService.rateAnswer(request, this);
    }


    @Override
    public void rateSuccess(RateResult rateResult) {
        rateButton.setText(getRateButtonLabel(rateResult.getAnswer()));
    }

    private String getRateButtonLabel(Answer answer) {
        if (answer.getRate() != null) {
            return getString(R.string.current_rating) + answer.getRate();
        }
        return getString(R.string.rate_answer);
    }

}
