package co.infinum.pokemon.mvp.interfaces;

/**
 * Created by Ivan on 16/05/16.
 */
public interface MvpListener<Model> {

    void onSuccess(Model model);

    void onFailure(String message);
}
