package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.dagger.scopes.ActivityScope;
import co.infinum.pokemon.mvp.interactors.PokedexInteractor;
import co.infinum.pokemon.mvp.interactors.PokemonDetailsInteractor;
import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails;
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
@ActivityScope
@Module
public class PokedexModule {

    private View view;

    public PokedexModule(View view) {
        this.view = view;
    }

    @Provides
    public View provideView() {
        return view;
    }

    @Provides
    public Interactor provideInteractor(PokedexInteractor interactor) {
        return interactor;
    }

    @Provides
    public Presenter providePresenter(PokedexPresenter presenter) {
        return presenter;
    }

    @Provides
    public MvpPokemonList.Interactor provideListInteractor(PokemonListInteractor interactor) {
        return interactor;
    }

    @Provides
    public MvpPokemonDetails.Interactor provideDetailsInteractor(PokemonDetailsInteractor interactor) {
        return interactor;
    }

}
