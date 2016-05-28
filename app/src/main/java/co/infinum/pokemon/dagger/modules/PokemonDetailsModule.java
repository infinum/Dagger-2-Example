package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.dagger.scopes.ActivityScope;
import co.infinum.pokemon.data.interactors.pokemon.details.PokemonDetailsInteractor;
import co.infinum.pokemon.data.interactors.pokemon.details.PokemonDetailsInteractorImpl;
import co.infinum.pokemon.ui.pokemon.details.PokemonDetailsPresenter;
import co.infinum.pokemon.ui.pokemon.details.PokemonDetailsPresenterImpl;
import co.infinum.pokemon.ui.pokemon.details.PokemonDetailsView;
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

    @ActivityScope
    @Provides
    public PokemonDetailsView provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    public PokemonDetailsPresenter providePresenter(PokemonDetailsPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    public PokemonDetailsInteractor provideInteractor(PokemonDetailsInteractorImpl interactor) {
        return interactor;
    }
}
