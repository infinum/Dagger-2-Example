package co.infinum.pokemon.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;

import co.infinum.pokemon.PokemonApp;
import co.infinum.pokemon.R;
import co.infinum.pokemon.dagger.components.AppComponent;

/**
 * Created by dino on 21/03/15.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected Dialog progressDialog;

    protected abstract void injectDependencies(AppComponent appComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(((PokemonApp) getApplication()).getApplicationComponent());
    }

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
        builder.setPositiveButton(android.R.string.ok, null);

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
