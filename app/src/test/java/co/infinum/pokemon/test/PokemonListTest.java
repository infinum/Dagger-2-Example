package co.infinum.pokemon.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import co.infinum.pokemon.BuildConfig;
import co.infinum.pokemon.core.Core;
import co.infinum.pokemon.test.dagger.components.DaggerCoreComponent;
import co.infinum.pokemon.test.dagger.modules.NetworkModule;

/**
 * Created by ivan on 12/10/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class PokemonListTest {

    @Before
    public void setUp() {
        //TODO Reinject the core with mock networking module.
        Core.inject(
                DaggerCoreComponent.builder()
                        .networkModule(new NetworkModule())
                        .build()
                        .inject()
        );
    }
    @After
    public void tearDown() {

    }

    @Test
    public void testList() {
        //TODO test goes here
    }
}
