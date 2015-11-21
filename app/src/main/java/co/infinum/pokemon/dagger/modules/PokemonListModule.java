package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.mvp.interactors.PokemonListDatabaseInteractorImpl;
import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.interactors.impl.PokemonListInteractorImpl;
import co.infinum.pokemon.mvp.presenters.PokemonListPresenter;
import co.infinum.pokemon.mvp.presenters.impl.PokemonListPresenterImpl;
import co.infinum.pokemon.mvp.views.PokemonListView;
import co.infinum.pokemon.network.PokemonService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class PokemonListModule {

    private final PokemonListView view;

    private final boolean hasNetworkConnection;

    public PokemonListModule(PokemonListView view, boolean hasNetworkConnection) {
        this.view = view;
        this.hasNetworkConnection = hasNetworkConnection;
    }

    @Provides
    public PokemonListView provideView() {
        return view;
    }

    @Provides
    public PokemonListInteractor provideInteractor(PokemonService pokemonService) {

        if (hasNetworkConnection) {
            return new PokemonListInteractorImpl(pokemonService);
        } else {
            return new PokemonListDatabaseInteractorImpl();
        }

    }

    @Provides
    public PokemonListPresenter providePresenter(PokemonListPresenterImpl presenter) {
        return presenter;
    }
}
