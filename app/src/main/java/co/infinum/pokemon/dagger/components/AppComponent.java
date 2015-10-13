package co.infinum.pokemon.dagger.components;

import javax.inject.Singleton;

import co.infinum.pokemon.PokemonApp;
import dagger.Component;
import co.infinum.pokemon.dagger.modules.ApiModule;
import co.infinum.pokemon.dagger.modules.DefaultExecutorsModule;
import co.infinum.pokemon.dagger.modules.HostModule;

/**
 * Created by dino on 13/10/15.
 */
@Component(modules = {
        HostModule.class,
        DefaultExecutorsModule.class,
        ApiModule.class
})
@Singleton
public interface AppComponent {

    void inject(PokemonApp app);
}
