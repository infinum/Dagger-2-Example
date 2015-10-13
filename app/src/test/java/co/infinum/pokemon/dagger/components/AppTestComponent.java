package co.infinum.pokemon.dagger.components;

import javax.inject.Singleton;

import co.infinum.pokemon.PokemonApp;
import co.infinum.pokemon.dagger.modules.MockHostModule;
import co.infinum.pokemon.dagger.modules.SynchronousExecutorsModule;
import dagger.Component;
import co.infinum.pokemon.dagger.modules.ApiModule;

/**
 * Created by dino on 13/10/15.
 */
@Component(modules = {
        MockHostModule.class,
        SynchronousExecutorsModule.class,
        ApiModule.class
})
@Singleton
public interface AppTestComponent {

    void inject(PokemonApp app);
}
