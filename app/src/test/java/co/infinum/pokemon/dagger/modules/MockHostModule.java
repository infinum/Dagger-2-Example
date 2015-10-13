package co.infinum.pokemon.dagger.modules;

import com.squareup.okhttp.mockwebserver.MockWebServer;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;

/**
 * Created by dino on 27/02/15.
 */
@Module
public class MockHostModule {

    public static final int NETWORK_TIMEOUT_SECONDS = 1;

    private MockWebServer mockWebServer;

    public MockHostModule() {
        mockWebServer = new MockWebServer();
        try {
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to start mockWebServer!");
        }
    }

    @Provides
    @Singleton
    public Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(mockWebServer.url("/").toString());
    }

    public MockWebServer getMockWebServer() {
        return mockWebServer;
    }

    @Provides
    @Singleton
    public Integer provideNetworkTimeout() {
        return NETWORK_TIMEOUT_SECONDS;
    }
}
