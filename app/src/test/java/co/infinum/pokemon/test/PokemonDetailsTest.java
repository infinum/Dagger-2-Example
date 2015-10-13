package co.infinum.pokemon.test;

import com.squareup.okhttp.mockwebserver.RecordedRequest;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;

import android.content.Intent;

import co.infinum.pokemon.activities.PokemonDetailsActivity;
import co.infinum.pokemon.helpers.CustomRobolectricGradleTestRunner;
import co.infinum.pokemon.models.Pokemon;

/**
 * Created by ivan on 12/10/15.
 */
@RunWith(CustomRobolectricGradleTestRunner.class)
public class PokemonDetailsTest extends BaseTest {

    private PokemonDetailsActivity buildActivity(Pokemon pokemon) {
        Intent intent = new Intent(RuntimeEnvironment.application, PokemonDetailsActivity.class);
        intent.putExtra(PokemonDetailsActivity.EXTRA_POKEMON, pokemon);
        return Robolectric.buildActivity(PokemonDetailsActivity.class)
                .withIntent(intent)
                .create()
                .start()
                .resume()
                .visible()
                .get();
    }

    @Test
    public void shouldMakeRequestToCorrectResourceUri() throws Exception {
        String resourceUri = "api/v1/pokemon/6/";
        Pokemon pokemon = new Pokemon();
        pokemon.setResourceUri(resourceUri);

        buildActivity(pokemon);

        RecordedRequest request = takeLastRequest();
        Assert.assertEquals("/" + resourceUri, request.getPath());
    }
}
