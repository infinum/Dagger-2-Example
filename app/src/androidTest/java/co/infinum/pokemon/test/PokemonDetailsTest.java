package co.infinum.pokemon.test;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import junit.framework.TestCase;

import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.presenters.PokemonDetailsPresenter;
import co.infinum.pokemon.mvp.views.PokemonDetailsView;
import co.infinum.pokemon.test.dagger.components.DaggerPokemonDetailsTestComponent;
import co.infinum.pokemon.test.dagger.components.PokemonDetailsTestComponent;
import co.infinum.pokemon.test.dagger.modules.MockHostModule;
import co.infinum.pokemon.test.dagger.modules.PokemonDetailsModule;
import co.infinum.pokemon.test.helpers.ResourceUtils;

import static co.infinum.pokemon.test.helpers.TestHelper.verifyAsync;
import static co.infinum.pokemon.test.helpers.TestHelper.verifyShowHideProgress;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

/**
 * Created by Ivan on 9/22/14.
 */
public class PokemonDetailsTest extends TestCase {

    private static Pokemon charizard = new Pokemon();

    static {
        charizard.setName("charizard");
        charizard.setResourceUri("api/v1/pokemon/6/");
    }

    private MockWebServer mockWebServer;

    private PokemonDetailsPresenter presenter;

    private PokemonDetailsView view;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        view = mock(PokemonDetailsView.class);
        MockHostModule mockHostModule = new MockHostModule();

        PokemonDetailsTestComponent component = DaggerPokemonDetailsTestComponent.builder()
                .mockHostModule(mockHostModule)
                .pokemonDetailsModule(new PokemonDetailsModule(view))
                .build();

        presenter = component.presenter();
        mockWebServer = mockHostModule.getMockWebServer();
    }

    @Override
    protected void tearDown() throws Exception {
        mockWebServer.shutdown();
        super.tearDown();
    }

    private void enqueueResponse(String filename) {
        MockResponse mockResponse = new MockResponse().setBody(ResourceUtils.readFromFile(filename));
        mockWebServer.enqueue(mockResponse);
    }

    public void testEmptyResponse() throws Exception {
        // 200 OK with empty body
        MockResponse mockResponse = new MockResponse().setBody("");

        mockWebServer.enqueue(mockResponse);
        presenter.loadDetails(charizard);

        // we want to show an error and not crash the app
        verifyAsync(view).showError(anyString());
        verifyShowHideProgress(view);
    }

    public void testCharizardDetails() throws Exception {
        enqueueResponse("charizard_details.json");

        presenter.loadDetails(charizard);

        verifyAsync(view).showName("Charizard");
        verifyAsync(view).showHp("78");
        verifyAsync(view).showWeight("410 kg");
        verifyAsync(view).showHeight("518 cm");
        verifyAsync(view).showAttack("84");
        verifyAsync(view).showDefense("78");
        verifyShowHideProgress(view);
    }
}
