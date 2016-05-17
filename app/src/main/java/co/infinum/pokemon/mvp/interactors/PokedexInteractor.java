package co.infinum.pokemon.mvp.interactors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.infinum.pokemon.PokemonApp;
import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpListener;
import co.infinum.pokemon.mvp.interfaces.MvpPokedex;

/**
 * Created by Ivan on 16/05/16.
 */
public class PokedexInteractor implements MvpPokedex.Interactor{

    private static final String POKEMON_LIST = "POKEMON_LIST";

    private Gson gson;

    @Inject
    public PokedexInteractor() {
        gson = new Gson();
    }

    @Override
    public void loadKnownPokemonList(MvpListener<Pokedex> pokemonListListener) {
        Pokedex pokedex = new Pokedex();
        pokedex.setPokemons(getPokemonList());
        pokemonListListener.onSuccess(pokedex);
    }

    @Override
    public boolean addPokemon(Pokemon pokemon) {
        List<Pokemon> pokemons = getPokemonList();
        if (!pokemons.contains(pokemon)) {
            pokemons.add(pokemon);
            savePokemons(pokemons);
            return true;
        }

        return false;
    }

    private void savePokemons(List<Pokemon> pokemons) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(PokemonApp.getInstance());
        String pokemonsJson = gson.toJson(pokemons, new TypeToken<List<Pokemon>>(){}.getType());
        sp.edit().putString(POKEMON_LIST, pokemonsJson).apply();
    }

    private List<Pokemon> getPokemonList() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(PokemonApp.getInstance());
        String pokemonsJson = sp.getString(POKEMON_LIST, "");
        List<Pokemon> pokemons;
        if (TextUtils.isEmpty(pokemonsJson)) {
            pokemons = new ArrayList<>();
        } else {
            pokemons = gson.fromJson(pokemonsJson, new TypeToken<List<Pokemon>>(){}.getType());
        }

        return pokemons;
    }

    @Override
    public void cancel() {

    }

    @Override
    public void reset() {

    }
}
