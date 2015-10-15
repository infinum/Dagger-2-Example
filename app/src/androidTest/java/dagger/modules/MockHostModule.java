package dagger.modules;

import com.squareup.okhttp.mockwebserver.MockWebServer;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;

/**
 * Created by dino on 27/02/15.
 */
@Module
public class MockHostModule {

    private MockWebServer mockWebServer;

    public MockHostModule() {
        mockWebServer = new MockWebServer();
        try {
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Provides
    public Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(mockWebServer.getUrl("/").toString());
    }

    public MockWebServer getMockWebServer() {
        return mockWebServer;
    }
}
