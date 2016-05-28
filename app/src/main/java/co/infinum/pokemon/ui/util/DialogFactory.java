package co.infinum.pokemon.ui.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

/**
 * Created by jmarkovic on 29/05/16.
 */

public final class DialogFactory {

    public AlertDialog showOkDialog(@NonNull Context context, String message) {
        return new AlertDialog.Builder(context)
                .setMessage(message)
                .show();
    }

}
