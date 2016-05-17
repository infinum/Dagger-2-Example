package co.infinum.pokemon.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.LargeTest;

import co.infinum.pokemon.PokemonApp;
import co.infinum.pokemon.features.shared.PokemonDetailsActivity;
import co.infinum.pokemon.dagger.components.DaggerAppComponent;

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
        //TODO Reinject the app with mock networking module.
        DaggerAppComponent.builder()
                .build()
                .inject(PokemonApp.getInstance());

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDetails() throws Exception {
        //TODO test goes here
    }
}
