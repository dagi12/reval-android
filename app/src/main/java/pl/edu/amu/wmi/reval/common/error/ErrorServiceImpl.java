package pl.edu.amu.wmi.reval.common.error;

import android.content.Context;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ErrorServiceImpl implements Thread.UncaughtExceptionHandler {

    private static final String TAG = ErrorServiceImpl.class.getName();

    private final ErrorService errorService;

    private final Thread.UncaughtExceptionHandler defaultExceptionHandler;

    private final Context application;

    public ErrorServiceImpl(ErrorService errorService, Thread.UncaughtExceptionHandler defaultExceptionHandler, Context application) {
        this.application = application;
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
//        errorService.postErrorReport(errorReport).enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.errorBody() == null) {
//                    Log.i(TAG, "Wysłanie stacka na serwer powiodło się");
//                } else {
//                    Log.e(TAG, "Wysłanie stacka na serwer nie powiodło się");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Log.e(TAG, "Wysłanie stacka na serwer nie powiodło się", t);
//            }
//        });
        Log.e(TAG, "Wysłanie stacka na serwer nie powiodło się", e);
    }

    @Override
    public void uncaughtException(final Thread thread, final Throwable e) {
        if (NetworkContext.isOnline(application)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        errorService.postErrorReport(new ErrorReport(constructReportFromThrowable(e))).execute();
//                    } catch (IOException e1) {
//                        Log.e(TAG, "Błąd podczas wysyłania błędu xD", e1);
//                    }
                }
            }).start();
        }
        defaultExceptionHandler.uncaughtException(thread, e);
    }

}
