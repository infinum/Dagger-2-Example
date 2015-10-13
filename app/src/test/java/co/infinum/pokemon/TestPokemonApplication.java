package co.infinum.pokemon;

import co.infinum.pokemon.core.Core;
import co.infinum.pokemon.test.dagger.modules.NetworkModule;
import co.infinum.pokemon.test.dagger.components.DaggerTestCoreComponent;

/**
 * Test application that is run instead of {@link PokemonApplication} when Robolectric tests are run.
 */
public class TestPokemonApplication extends PokemonApplication {

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
