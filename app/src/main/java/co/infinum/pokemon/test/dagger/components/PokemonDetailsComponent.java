package co.infinum.pokemon.test.dagger.components;

import co.infinum.pokemon.activities.PokemonDetailsActivity;
import co.infinum.pokemon.test.dagger.modules.PokemonDetailsModule;
import dagger.Component;

/**
 * Created by dino on 12/05/15.
 */
@Component(modules = {
        PokemonDetailsModule.class
})
public interface PokemonDetailsComponent {

    void inject(PokemonDetailsActivity activity);
}
