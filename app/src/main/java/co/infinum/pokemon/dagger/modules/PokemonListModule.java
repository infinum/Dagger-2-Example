package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.dagger.scopes.ActivityScope;
import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.presenters.PokemonListPresenter;
import dagger.Module;
import dagger.Provides;

import static co.infinum.pokemon.mvp.interfaces.MvpPokemonList.*;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class PokemonListModule {

    private View view;

    public PokemonListModule(View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public View provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    public Interactor provideInteractor(PokemonListInteractor interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    public Presenter providePresenter(PokemonListPresenter presenter) {
        return presenter;
    }
}
