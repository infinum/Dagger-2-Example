package co.infinum.pokemon.test.dagger.components;

import co.infinum.pokemon.test.dagger.modules.MockNetworkModule;
import co.infinum.pokemon.test.dagger.modules.PokemonListModule;
import co.infinum.pokemon.mvp.presenters.PokemonListPresenter;
import dagger.Component;

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = {
        MockNetworkModule.class,
        PokemonListModule.class
})
public interface PokemonListTestComponent {

    PokemonListPresenter presenter();
}
