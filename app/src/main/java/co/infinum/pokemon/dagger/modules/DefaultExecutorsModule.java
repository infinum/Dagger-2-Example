package co.infinum.pokemon.dagger.modules;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.android.MainThreadExecutor;

/**
 * This module uses  to inject HTTP Client
 * and Callback executors. This implementation of Executors inject the default executors set
 * up by Retrofit RestClient.Builder.
 */
@Module
public class DefaultExecutorsModule {

    @Provides
    @Singleton
    @Named("HttpExecutor")
    public Executor provideHttpExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Provides
    @Singleton
    @Named("CallbackExecutor")
    public Executor provideCallbackExecutor() {
        return new MainThreadExecutor();
    }
}

