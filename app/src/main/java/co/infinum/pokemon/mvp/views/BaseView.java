package co.infinum.pokemon.mvp.views;

/**
 * Created by dino on 20/03/15.
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showError(String message);
}
