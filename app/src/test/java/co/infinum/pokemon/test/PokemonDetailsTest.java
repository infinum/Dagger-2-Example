package co.infinum.pokemon.test;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import co.infinum.pokemon.PokemonTestApp;
import co.infinum.pokemon.R;
import co.infinum.pokemon.activities.PokemonDetailsActivity;
import co.infinum.pokemon.helpers.CustomRobolectricGradleTestRunner;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.shadows.ShadowGson;
import co.infinum.pokemon.utils.ResourceUtils;

import static org.assertj.android.api.Assertions.assertThat;


/**
 * Created by ivan on 12/10/15.
 */
@RunWith(CustomRobolectricGradleTestRunner.class)
@Config(shadows = {ShadowGson.class})
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

        Activity activity = buildActivity(pokemon);

        RecordedRequest request = takeLastRequest();
        Assert.assertEquals("/" + resourceUri, request.getPath());
    }

    @Test
    public void nameOk() throws Exception {
        PokemonTestApp.getMockWebServer().enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setBody(ResourceUtils.readFromFile("charizard.json"))
        );

        String resourceUri = "api/v1/pokemon/6/";
        Pokemon pokemon = new Pokemon();
        pokemon.setResourceUri(resourceUri);

        Activity activity = buildActivity(pokemon);

        RecordedRequest request = takeLastRequest();

        //Check that name in details is displayed properly.
        assertThat(activity.findViewById(R.id.name)).isVisible();
        assertThat((TextView) activity.findViewById(R.id.name)).hasText("Charizard");
    }
}
