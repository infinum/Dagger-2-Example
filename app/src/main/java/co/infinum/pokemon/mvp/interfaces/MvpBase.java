package co.infinum.pokemon.mvp.interfaces;

/**
 * Created by Ivan on 16/05/16.
 */
public interface MvpBase {

    interface Interactor {

        void cancel();

        void reset();
    }

    interface Presenter {

        void cancel();
    }

    interface View {

        void showProgress();

        void hideProgress();

        void showError(String message);
    }
}
