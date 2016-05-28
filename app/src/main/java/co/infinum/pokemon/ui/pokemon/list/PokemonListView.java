package co.infinum.pokemon.ui.pokemon.list;

import java.util.List;

import co.infinum.pokemon.data.models.Pokemon;
import co.infinum.pokemon.ui.BaseView;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListView extends BaseView {

    void showPokemons(List<Pokemon> pokemons);

    void showPokemonDetails(Pokemon pokemon);
}
