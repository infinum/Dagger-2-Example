package dagger.components;

import co.infinum.pokemon.dagger.modules.PokemonDetailsModule;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails;
import dagger.Component;
import dagger.modules.MockNetworkModule;

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = {
        MockNetworkModule.class,
        PokemonDetailsModule.class
})
public interface PokemonDetailsTestComponent {

    MvpPokemonDetails.Presenter presenter();
}
