package co.infinum.pokemon.test.dagger.modules;

import android.util.Log;

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

    public PokemonService pokemonService;

    @Provides
    public PokemonService provideService(Endpoint endpoint) {
        if (pokemonService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(endpoint)
                    .setLog(new RestAdapter.Log() {
                        @Override
                        public void log(String message) {
                            Log.d("REST-ADAPTER", message);
                        }
                    })
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            pokemonService = restAdapter.create(PokemonService.class);
        }
        return pokemonService;
    }
}
