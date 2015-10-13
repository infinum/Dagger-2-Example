package co.infinum.pokemon.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import co.infinum.pokemon.activities.PokemonDetailsActivity;
import co.infinum.pokemon.core.Core;
import co.infinum.pokemon.test.dagger.components.DaggerCoreComponent;
import co.infinum.pokemon.test.dagger.modules.NetworkModule;

/**
 * Test for {@link PokemonDetailsActivity}.
 */
@LargeTest
public class PokemonDetailsEspressoTest {

    /**
     * Rule that defines {@link PokemonDetailsActivity} should be started before running tests.
     */
    @Rule
    public ActivityTestRule<PokemonDetailsActivity> activityRule =
            new ActivityTestRule<>(PokemonDetailsActivity.class, true, false);

    @Before
    public void setUp() throws Exception {
        //TODO Reinject the core with mock networking module.
        Core.inject(
                DaggerCoreComponent.builder()
                        .networkModule(new NetworkModule())
                        .build()
                        .inject()
        );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDetails() throws Exception {
        //TODO test goes here
    }
}
