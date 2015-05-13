package co.infinum.pokemon.test.dagger.modules;

import co.infinum.pokemon.mvp.interactors.PokemonDetailsInteractor;
import co.infinum.pokemon.mvp.interactors.impl.PokemonDetailsInteractorImpl;
import co.infinum.pokemon.mvp.presenters.PokemonDetailsPresenter;
import co.infinum.pokemon.mvp.presenters.impl.PokemonDetailsPresenterImpl;
import co.infinum.pokemon.mvp.views.PokemonDetailsView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class PokemonDetailsModule {

    private PokemonDetailsView view;

    public PokemonDetailsModule(PokemonDetailsView view) {
        this.view = view;
    }

    @Provides
    public PokemonDetailsView provideView() {
        return view;
    }

    @Provides
    public PokemonDetailsInteractor provideInteractor(PokemonDetailsInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public PokemonDetailsPresenter providePresenter(PokemonDetailsPresenterImpl presenter) {
        return presenter;
    }
}
