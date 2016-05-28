package dagger.components;

import dagger.modules.MockNetworkModule;
import co.infinum.pokemon.dagger.modules.PokemonListModule;
import co.infinum.pokemon.ui.pokemon.list.PokemonListPresenter;
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
