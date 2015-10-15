package co.infinum.pokemon.dagger.modules;

import com.squareup.okhttp.OkHttpClient;

import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import co.infinum.pokemon.network.PokemonService;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public PokemonService provideService(Endpoint endpoint, @Named("HttpExecutor") Executor httpExecutor,
            @Named("CallbackExecutor") Executor callbackExecutor, Integer networkTimeout) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(networkTimeout, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(networkTimeout, TimeUnit.SECONDS);
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.d("REST-ADAPTER", message);
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setExecutors(httpExecutor, callbackExecutor)
                .build().create(PokemonService.class);
    }
}
