package dagger.components;

import co.infinum.pokemon.dagger.modules.PokemonListModule;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonList;
import dagger.Component;
import dagger.modules.MockNetworkModule;

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = {
        MockNetworkModule.class,
        PokemonListModule.class
})
public interface PokemonListTestComponent {

    MvpPokemonList.Presenter presenter();
}
