package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.dagger.scopes.ActivityScope;
import co.infinum.pokemon.mvp.interactors.PokedexInteractor;
import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonList;
import co.infinum.pokemon.mvp.presenters.PokedexPresenter;
import dagger.Module;
import dagger.Provides;

import static co.infinum.pokemon.mvp.interfaces.MvpPokedex.Interactor;
import static co.infinum.pokemon.mvp.interfaces.MvpPokedex.Presenter;
import static co.infinum.pokemon.mvp.interfaces.MvpPokedex.View;

/**
 * Created by Ivan on 16/05/16.
 */
@Module
public class PokedexModule {

    private View view;

    public PokedexModule(View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public View provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    public Interactor provideInteractor(PokedexInteractor interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    public Presenter providePresenter(PokedexPresenter presenter) {
        return presenter;
    }

    @ActivityScope
    @Provides
    public MvpPokemonList.Interactor provideListInteractor(PokemonListInteractor interactor) {
        return interactor;
    }

}
