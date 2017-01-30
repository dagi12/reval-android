package pl.edu.amu.wmi.reval.common.services;


import android.content.Intent;
import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import pl.edu.amu.wmi.reval.SignInActivity;
import pl.edu.amu.wmi.reval.common.error.ErrorServiceImpl;
import pl.edu.amu.wmi.reval.common.error.NetworkContext;
import pl.edu.amu.wmi.reval.di.MyApplication;
import pl.edu.amu.wmi.reval.user.UserContext;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static pl.edu.amu.wmi.reval.di.MyApplication.getContext;

public abstract class MyCallback<T> implements Callback<T> {

    private static final String TAG = MyCallback.class.getName();
    private static final String FAILURE_MESSAGE = "Network failure";
    private static final int UNAUTHORIZED_STATUS_CODE = 401;
    private final MyCallbackInjectHelper myCallbackInjectHelper;

    public MyCallback() {
        this.myCallbackInjectHelper = new MyCallbackInjectHelper();
        myCallbackInjectHelper.inject();
    }

    private static String errorMessageFromResponse(Response response) {
        try {
            return response.message() + response.errorBody().string();
        } catch (IOException e) {
            Log.e(TAG, "Parse error exception", e);
            return response.message();
        }
    }

    protected abstract void onHandledResponse(Call<T> call, Response<T> response);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.errorBody() != null) {
            String errorMessage = errorMessageFromResponse(response);
            if (response.code() == UNAUTHORIZED_STATUS_CODE) {
                myCallbackInjectHelper.userContext.hardLogout();
            }
            Log.e(TAG, errorMessage);
        } else {
            onHandledResponse(call, response);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (!NetworkContext.isOffline()) {
            myCallbackInjectHelper.errorService.caughtException(throwable);
            Log.e(TAG, FAILURE_MESSAGE, throwable);
        }
    }

    public static class MyCallbackInjectHelper {

        @Inject
        ErrorServiceImpl errorService;

        @Inject
        UserContext userContext;

        private void inject() {
            MyApplication.getComponent().inject(this);
        }

    }

}
