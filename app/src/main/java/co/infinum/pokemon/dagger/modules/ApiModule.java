package co.infinum.pokemon.dagger.modules;

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
                    .build();
            pokemonService = restAdapter.create(PokemonService.class);
        }
        return pokemonService;
    }
}
