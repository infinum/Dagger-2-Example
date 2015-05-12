package co.infinum.pokemon.network;

import retrofit.RestAdapter;

/**
 * Created by dino on 21/03/15.
 */
public class ApiManager {

    public static final String API_URL = "http://pokeapi.co";

    public static final RestAdapter REST_ADAPTER = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .build();

    public static final PokemonService POKEMON_SERVICE = REST_ADAPTER.create(PokemonService.class);

    public static PokemonService getPokemonService() {
        return POKEMON_SERVICE;
    }
}
