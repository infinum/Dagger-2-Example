package co.infinum.pokemon.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dino on 20/03/15.
 */
public class Pokedex implements Serializable {

    public static final String POKEMON = "pokemon";

    @SerializedName(POKEMON)
    private List<Pokemon> pokemons;

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
