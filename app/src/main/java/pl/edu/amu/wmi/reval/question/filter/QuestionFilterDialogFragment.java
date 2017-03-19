package pl.edu.amu.wmi.reval.question.filter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.edu.amu.wmi.reval.R;
import pl.edu.amu.wmi.reval.common.activity.SubjectTopicContainer;
import pl.edu.amu.wmi.reval.common.dialog.MyBottomSheetDialogFragment;
import pl.edu.amu.wmi.reval.common.exception.AdapterLackException;
import pl.edu.amu.wmi.reval.di.MyApplication;


public class QuestionFilterDialogFragment extends MyBottomSheetDialogFragment {

    private QuestionRequestAdapter adapter;

    private SubjectTopicContainer container;

    public static QuestionFilterDialogFragment getInstance() {
        return new QuestionFilterDialogFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        Context context = getActivity();
        if (context instanceof QuestionRequestAdapter) {
            adapter = (QuestionRequestAdapter) context;
        } else {
            throw new AdapterLackException(context, QuestionRequestAdapter.class);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        container = new SubjectTopicContainer(getActivity(), getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_filter_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.search_question)
    public void search() {
        QuestionRequestParameters parameters = container.getParameters();
        if (parameters != null) {
            adapter.populateFilter(parameters);
            dismiss();
        }
    }

}
