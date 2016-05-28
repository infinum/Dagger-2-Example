package co.infinum.pokemon.data.remote;

import co.infinum.pokemon.data.models.Pokedex;
import co.infinum.pokemon.data.models.Pokemon;
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
    void getPokemon(@Path(value = "resource_uri", encode = false) String resourceUri, Callback<Pokemon> callback);
}
