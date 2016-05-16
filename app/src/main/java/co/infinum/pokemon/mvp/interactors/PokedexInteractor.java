package co.infinum.pokemon.mvp.interactors;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpListener;
import co.infinum.pokemon.mvp.interfaces.MvpPokedex;

/**
 * Created by Ivan on 16/05/16.
 */
public class PokedexInteractor implements MvpPokedex.Interactor{

    @Inject
    public PokedexInteractor() {
    }

    @Override
    public void loadKnownPokemonList(MvpListener<Pokedex> pokemonListListener) {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("bulbasaur"));
        pokemons.add(new Pokemon("squirtle"));
        pokemons.add(new Pokemon("weedle"));
        Pokedex pokedex = new Pokedex();
        pokedex.setPokemons(pokemons);
        pokemonListListener.onSuccess(pokedex);
    }

    @Override
    public void cancel() {

    }

    @Override
    public void reset() {

    }
}
