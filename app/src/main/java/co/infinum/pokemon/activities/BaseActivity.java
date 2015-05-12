package co.infinum.pokemon.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;

import co.infinum.pokemon.R;
import co.infinum.pokemon.mvp.views.BaseView;

/**
 * Created by dino on 21/03/15.
 */
public class BaseActivity extends AppCompatActivity implements BaseView {

    protected Dialog progressDialog;

    protected void showProgressDialog() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCanceledOnTouchOutside(false);
            if (!isFinishing()) {
                progressDialog.show();
            }
        }
    }

    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            if (!isFinishing()) {
                progressDialog.dismiss();
            }
        }
    }

    protected void showDialog(final String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.app_name);
        if (message != null) {
            builder.setMessage(Html.fromHtml(message));
        } else {
            builder.setMessage("");
        }
        DialogInterface.OnClickListener onOkClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        builder.setPositiveButton(android.R.string.ok, onOkClick);

        if (!isFinishing()) {
            builder.show();
        }
    }

    @Override
    public void showProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        hideProgressDialog();
    }

    @Override
    public void showError(String message) {
        showDialog(message);
    }
}
