package co.infinum.pokemon.test;

import com.google.gson.Gson;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.Before;
import org.robolectric.shadows.ShadowLog;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import co.infinum.pokemon.PokemonTestApp;
import co.infinum.pokemon.helpers.ResourceUtils;

/**
 * Created by Željko Plesac on 07/09/15.
 */
public class BaseTest {

    private MockWebServer mockWebServer;

    @Before
    public void setup() throws Exception {
        mockWebServer = PokemonTestApp.getMockWebServer();

        ShadowLog.stream = System.out;
    }

    protected Gson getGson() {
        return PokemonTestApp.getGson();
    }

    protected void enqueueResponse(String filename) {
        String body = ResourceUtils.readFromFile(filename);
        MockResponse mockResponse = new MockResponse().setBody(body).setResponseCode(HttpURLConnection.HTTP_OK);
        mockWebServer.enqueue(mockResponse);
    }

    protected void enqueueResponse(String filename, int statusCode) {
        String body = ResourceUtils.readFromFile(filename);
        MockResponse mockResponse = new MockResponse().setBody(body).setResponseCode(statusCode);
        mockWebServer.enqueue(mockResponse);
    }

    protected void enqueueEmptyResponse(int statusCode) {
        MockResponse mockResponse = new MockResponse().setBody("").setResponseCode(statusCode);
        mockWebServer.enqueue(mockResponse);
    }

    protected RecordedRequest takeLastRequest() throws InterruptedException {
        int requestCount = mockWebServer.getRequestCount();
        while (requestCount > 1) {
            mockWebServer.takeRequest(10, TimeUnit.SECONDS);
            requestCount--;
        }

        return mockWebServer.takeRequest(10, TimeUnit.SECONDS);
    }
}
