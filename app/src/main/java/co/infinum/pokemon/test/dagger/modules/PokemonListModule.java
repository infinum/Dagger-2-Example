package co.infinum.pokemon.test.dagger.modules;

import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.interactors.impl.PokemonListInteractorImpl;
import co.infinum.pokemon.mvp.presenters.PokemonListPresenter;
import co.infinum.pokemon.mvp.presenters.impl.PokemonListPresenterImpl;
import co.infinum.pokemon.mvp.views.PokemonListView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class PokemonListModule {

    private PokemonListView view;

    public PokemonListModule(PokemonListView view) {
        this.view = view;
    }

    @Provides
    public PokemonListView provideView() {
        return view;
    }

    @Provides
    public PokemonListInteractor provideInteractor() {
        return new PokemonListInteractorImpl();
    }

    @Provides
    public PokemonListPresenter providePresenter(PokemonListPresenterImpl presenter) {
        return presenter;
    }
}
