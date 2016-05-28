package co.infinum.pokemon.data.interactors;

/**
 * Created by dino on 20/03/15.
 */
public interface BaseInteractor<T extends BaseListener> {

    void provideListener(T listener);

    void cancel();

    void reset();
}
