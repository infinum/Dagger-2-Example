package co.infinum.pokemon.ui.pokemon.list;

import co.infinum.pokemon.data.models.Pokemon;
import co.infinum.pokemon.ui.BasePresenter;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListPresenter extends BasePresenter {

    void loadPokemonList();

    void onPokemonSelected(Pokemon pokemon);
}
