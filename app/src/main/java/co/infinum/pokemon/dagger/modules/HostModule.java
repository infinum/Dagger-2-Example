package co.infinum.pokemon.dagger.modules;

import javax.inject.Singleton;

import co.infinum.pokemon.BuildConfig;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;

/**
 * Created by dino on 27/02/15.
 */
@Module
public class HostModule {

    public static final int NETWORK_TIMEOUT_SECONDS = 30;

    @Provides
    @Singleton
    public Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(BuildConfig.API_URL);
    }

    @Provides
    @Singleton
    public Integer provideNetworkTimeout() {
        return NETWORK_TIMEOUT_SECONDS;
    }
}
