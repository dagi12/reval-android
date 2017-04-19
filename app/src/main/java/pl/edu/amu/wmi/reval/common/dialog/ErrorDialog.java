package pl.edu.amu.wmi.reval.common.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import pl.edu.amu.wmi.reval.R;


public class ErrorDialog {

    private ErrorDialog() {
    }

    public static Dialog getInstance(Context context, String errorMessage) {
        return buildDialog(context, errorMessage);
    }

    private static Dialog buildDialog(Context context, String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AppTheme_MyAlertDialogStyle);
        builder
                .setMessage(errorMessage)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }


}
