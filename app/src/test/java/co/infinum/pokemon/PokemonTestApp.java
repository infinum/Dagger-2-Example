package co.infinum.pokemon;

import com.google.gson.Gson;

import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.robolectric.TestLifecycleApplication;

import android.annotation.SuppressLint;

import java.lang.reflect.Method;

import co.infinum.pokemon.dagger.components.AppTestComponent;
import co.infinum.pokemon.dagger.components.DaggerAppTestComponent;
import co.infinum.pokemon.dagger.modules.MockHostModule;

/**
 * Test application that is run instead of {@link PokemonApp} when Robolectric tests are run.
 */
public class PokemonTestApp extends PokemonApp implements TestLifecycleApplication {

    private static MockWebServer mockWebServer;

    public static MockWebServer getMockWebServer() {
        return mockWebServer;
    }

    public static void setMockWebServer(MockHostModule mockHostModule) {
        mockWebServer = mockHostModule.getMockWebServer();
    }

    public static Gson getGson() {
        return new Gson();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate() {
        // Don't call super so the dependencies don't get injected.
        setInstance(this);
    }

    /**
     * Prepares the MockWebServer before each test
     */
    @Override
    public void beforeTest(Method method) {
        MockHostModule mockHostModule = new MockHostModule();
        setMockWebServer(mockHostModule);
        AppTestComponent appTestComponent = DaggerAppTestComponent.builder()
                .mockHostModule(mockHostModule)
                .build();
        appTestComponent.inject(this);
    }

    @Override
    public void prepareTest(Object test) {

    }

    @Override
    public void afterTest(Method method) {
        try {
            mockWebServer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
