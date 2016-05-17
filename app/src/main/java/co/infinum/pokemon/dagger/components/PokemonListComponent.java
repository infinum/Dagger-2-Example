package co.infinum.pokemon.dagger.components;

import co.infinum.pokemon.features.overview.PokemonListActivity;
import co.infinum.pokemon.dagger.modules.PokemonListModule;
import co.infinum.pokemon.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by dino on 12/05/15.
 */
@ActivityScope
@Subcomponent(modules = {
        PokemonListModule.class
})
public interface PokemonListComponent {

    void inject(PokemonListActivity activity);
}
