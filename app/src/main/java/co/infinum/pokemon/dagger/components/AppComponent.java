package co.infinum.pokemon.dagger.components;

import javax.inject.Singleton;

import co.infinum.pokemon.PokemonApp;
import co.infinum.pokemon.dagger.modules.ApplicationModule;
import co.infinum.pokemon.dagger.modules.DatabaseModule;
import co.infinum.pokemon.dagger.modules.DefaultExecutorsModule;
import co.infinum.pokemon.dagger.modules.HostModule;
import co.infinum.pokemon.dagger.modules.NetworkModule;
import co.infinum.pokemon.dagger.modules.PokemonDetailsModule;
import co.infinum.pokemon.dagger.modules.PokemonListModule;
import dagger.Component;

/**
 * Created by dino on 13/10/15.
 */
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        HostModule.class,
        DefaultExecutorsModule.class,
        DatabaseModule.class
})
@Singleton
public interface AppComponent {

    void inject(PokemonApp app);

    PokemonListComponent plus(PokemonListModule pokemonListModule);

    PokemonDetailsComponent plus(PokemonDetailsModule module);

}
