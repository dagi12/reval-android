package pl.edu.amu.wmi.reval.common.error;

import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ErrorServiceImpl implements Thread.UncaughtExceptionHandler {

    private static final String TAG = ErrorServiceImpl.class.getName();

    private final ErrorService errorService;

    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;

    public ErrorServiceImpl(ErrorService errorService, Thread.UncaughtExceptionHandler defaultExceptionHandler) {
        this.errorService = errorService;
        this.defaultExceptionHandler = defaultExceptionHandler;
    }

    private String constructReportFromThrowable(Throwable e) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        e.printStackTrace(printWriter);
        printWriter.close();
        return result.toString();
    }

    public void caughtException(final Throwable e) {
        ErrorReport errorReport = new ErrorReport(constructReportFromThrowable(e));
        errorService.postErrorReport(errorReport).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.errorBody() == null) {
                    Log.i(TAG, "Wysłanie stacka na serwer powiodło się");
                } else {
                    Log.e(TAG, "Wysłanie stacka na serwer nie powiodło się");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e(TAG, "Wysłanie stacka na serwer nie powiodło się", t);
            }
        });
    }

    @Override
    public void uncaughtException(final Thread thread, final Throwable e) {
        if (NetworkContext.isOnline()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        errorService.postErrorReport(new ErrorReport(constructReportFromThrowable(e))).execute();
                    } catch (IOException e1) {
                        Log.e(TAG, "Błąd podczas wysyłania błędu xD", e1);
                    }
                }
            }).start();
        }
        defaultExceptionHandler.uncaughtException(thread, e);
    }

}
