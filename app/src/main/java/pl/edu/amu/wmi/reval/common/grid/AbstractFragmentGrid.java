package pl.edu.amu.wmi.reval.common.grid;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.common.services.PicassoCache;


public abstract class AbstractFragmentGrid<T extends AbstractRevalItem, S extends AbstractViewHolder<T>> extends Fragment {

    protected static final String RECYCLER_VIEW_ID_PARAM = "RECYCLER_VIEW_ID";
    @Inject
    protected PicassoCache picassoCache;
    protected ProgressDialog progressDialog;
    private OnListFragmentInteractionListener<T> mListener;
    private MyRecyclerViewAdapter<T, S> myRecyclerViewAdapter;

    protected void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        myRecyclerViewAdapter = new MyRecyclerViewAdapter<>(this);
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getListWrapperId(), container, false);
        int recyclerViewId = 0;
        if (getArguments() != null) {
            recyclerViewId = getArguments().getInt(RECYCLER_VIEW_ID_PARAM);
        }
        if (recyclerViewId == 0) {
            if (view instanceof RecyclerView) {
                initRecyclerView((RecyclerView) view);
            } else {

                throw new WrongViewException();
            }
        } else {
            initRecyclerView((RecyclerView) view.findViewById(recyclerViewId));
        }
        return view;
    }

    protected abstract int getListWrapperId();

    public void setData(List<T> items) {
        progressDialog.dismiss();
        myRecyclerViewAdapter.setmValues(items);
        myRecyclerViewAdapter.notifyDataSetChanged();
    }

    public abstract S createViewHolder(View view);

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        initContext(activity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initContext(context);
    }

    @SuppressWarnings("unchecked")
    private void initContext(Context context) {
        progressDialog = new ProgressDialog(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        }
    }

    public abstract int getItemViewId();

    public void setListenerRow(final S holder, T t) {
        holder.item = t;
        holder.setRow();
        holder.view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onListFragmentInteraction(holder.item);
                }
            }
        });
    }

    public void addData(T items) {
        progressDialog.dismiss();
        myRecyclerViewAdapter.addValue(items);
        myRecyclerViewAdapter.notifyDataSetChanged();
    }

    public void update(T postRequestResult) {
        myRecyclerViewAdapter.updateValue(postRequestResult);
        myRecyclerViewAdapter.notifyDataSetChanged();
    }

    public void delete(int postId) {
        myRecyclerViewAdapter.delete(postId);
        myRecyclerViewAdapter.notifyDataSetChanged();
    }

    private static class WrongViewException extends RuntimeException {

        private static final String MESSAGE = "Widok musi być RecyclerView";

        WrongViewException() {
            super(MESSAGE);
        }
    }
}
