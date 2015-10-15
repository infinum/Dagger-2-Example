package dagger.components;

import dagger.modules.MockNetworkModule;
import co.infinum.pokemon.dagger.modules.PokemonDetailsModule;
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
