package co.infinum.pokemon.network;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ivan on 09/06/14.
 */
public interface PokemonService {

    @GET("/api/v1/pokedex/1")
    void getPokedex(Callback<Pokedex> callback);

    @GET("/{resource_uri}")
    void getPokemon(@Path("resource_uri") String resourceUri, Callback<Pokemon> callback);
}
