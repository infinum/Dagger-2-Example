package co.infinum.pokemon.mvp.views;

import java.util.List;

import co.infinum.pokemon.models.Pokemon;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListView extends BaseView {

    void showPokemons(List<Pokemon> pokemons, String fetchedFrom);

    void showPokemonDetails(Pokemon pokemon);
}
