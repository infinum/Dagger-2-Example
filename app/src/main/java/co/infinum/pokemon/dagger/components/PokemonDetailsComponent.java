package co.infinum.pokemon.dagger.components;

import co.infinum.pokemon.activities.PokemonDetailsActivity;
import co.infinum.pokemon.dagger.modules.NetworkModule;
import co.infinum.pokemon.dagger.modules.PokemonDetailsModule;
import dagger.Component;

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = {
        NetworkModule.class,
        PokemonDetailsModule.class
})
public interface PokemonDetailsComponent {

    void inject(PokemonDetailsActivity activity);
}
