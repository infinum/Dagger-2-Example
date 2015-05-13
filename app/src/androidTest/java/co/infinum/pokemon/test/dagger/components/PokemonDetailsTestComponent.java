package co.infinum.pokemon.test.dagger.components;

import co.infinum.pokemon.test.dagger.modules.MockNetworkModule;
import co.infinum.pokemon.test.dagger.modules.PokemonDetailsModule;
import co.infinum.pokemon.mvp.presenters.PokemonDetailsPresenter;
import dagger.Component;

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = {
        MockNetworkModule.class,
        PokemonDetailsModule.class
})
public interface PokemonDetailsTestComponent {

    PokemonDetailsPresenter presenter();
}
