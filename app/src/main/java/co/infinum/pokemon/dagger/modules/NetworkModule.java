package co.infinum.pokemon.dagger.modules;

import com.squareup.okhttp.OkHttpClient;

import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import co.infinum.pokemon.data.remote.PokemonService;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public RestAdapter.Log provideLogger() {
        return new RestAdapter.Log() {
            @Override
            public void log(String message) {
                Log.d("REST-ADAPTER", message);
            }
        };
    }

    // todo move to separate module
    @Provides
    @Singleton
    public OkHttpClient provideClient(Integer networkTimeout) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(networkTimeout, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(networkTimeout, TimeUnit.SECONDS);
        return okHttpClient;
    }


    @Provides
    @Singleton
    public PokemonService provideService(Endpoint endpoint, @Named("HttpExecutor") Executor httpExecutor,
                                         @Named("CallbackExecutor") Executor callbackExecutor, OkHttpClient client,
                                         RestAdapter.Log log) {

        return new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(endpoint)
                .setLog(log)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setExecutors(httpExecutor, callbackExecutor)
                .build().create(PokemonService.class);
    }
}
