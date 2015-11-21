package co.infinum.pokemon.dagger.modules;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.raizlabs.android.dbflow.structure.ModelAdapter;
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
import retrofit.converter.GsonConverter;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public Gson provideGson () {
        return new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaredClass().equals(ModelAdapter.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();
    }

    @Provides
    @Singleton
    public PokemonService provideService(Endpoint endpoint, @Named("HttpExecutor") Executor httpExecutor,
            @Named("CallbackExecutor") Executor callbackExecutor, Integer networkTimeout,
                                         Gson gson) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(networkTimeout, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(networkTimeout, TimeUnit.SECONDS);
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setConverter(new GsonConverter(gson))
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
