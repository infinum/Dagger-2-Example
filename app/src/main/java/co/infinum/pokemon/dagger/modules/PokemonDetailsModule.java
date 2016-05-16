package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.dagger.scopes.ActivityScope;
import co.infinum.pokemon.mvp.interactors.PokemonDetailsInteractor;
import co.infinum.pokemon.mvp.presenters.PokemonDetailsPresenter;
import dagger.Module;
import dagger.Provides;

import static co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails.*;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class PokemonDetailsModule {

    private View view;

    public PokemonDetailsModule(View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public View provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    public Interactor provideInteractor(PokemonDetailsInteractor interactor) {
        return interactor;
    }

    @ActivityScope
    @Provides
    public Presenter providePresenter(PokemonDetailsPresenter presenter) {
        return presenter;
    }
}
