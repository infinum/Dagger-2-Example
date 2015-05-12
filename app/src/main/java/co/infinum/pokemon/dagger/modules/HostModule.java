package co.infinum.pokemon.dagger.modules;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;

/**
 * Created by dino on 27/02/15.
 */
@Module
public class HostModule {

    public static final String API_URL = "http://pokeapi.co";

    @Provides
    public Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(API_URL);
    }
}
