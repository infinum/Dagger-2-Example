package dagger.components;

import co.infinum.pokemon.dagger.modules.PokemonDetailsModule;
import co.infinum.pokemon.dagger.scopes.ActivityScope;
import dagger.modules.MockNetworkModule;
import co.infinum.pokemon.ui.pokemon.details.PokemonDetailsPresenter;
import dagger.Component;

/**
 * Created by dino on 12/05/15.
 */
@ActivityScope
@Component(modules = {
        MockNetworkModule.class,
        PokemonDetailsModule.class
})
public interface PokemonDetailsTestComponent {

    PokemonDetailsPresenter presenter();
}
