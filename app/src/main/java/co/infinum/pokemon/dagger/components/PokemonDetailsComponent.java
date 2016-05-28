package co.infinum.pokemon.dagger.components;

import co.infinum.pokemon.dagger.modules.PokemonDetailsModule;
import co.infinum.pokemon.dagger.scopes.ActivityScope;
import co.infinum.pokemon.ui.pokemon.details.PokemonDetailsActivity;
import dagger.Subcomponent;

/**
 * Created by dino on 12/05/15.
 */
@ActivityScope
@Subcomponent(modules = {
        PokemonDetailsModule.class
})
public interface PokemonDetailsComponent {

    void inject(PokemonDetailsActivity activity);
}
