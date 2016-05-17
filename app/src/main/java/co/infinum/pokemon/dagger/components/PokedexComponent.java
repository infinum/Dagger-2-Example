package co.infinum.pokemon.dagger.components;

import co.infinum.pokemon.features.pokedex.PokedexActivity;
import co.infinum.pokemon.dagger.modules.PokedexModule;
import co.infinum.pokemon.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Ivan on 16/05/16.
 */
@ActivityScope
@Subcomponent(modules = {
        PokedexModule.class
})
public interface PokedexComponent {

    void inject(PokedexActivity activity);
}
