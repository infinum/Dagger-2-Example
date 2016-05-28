package co.infinum.pokemon.data.interactors.pokemon.list;

import co.infinum.pokemon.data.interactors.BaseListener;
import co.infinum.pokemon.data.models.Pokedex;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListListener extends BaseListener {

    void onSuccess(Pokedex pokedex);
}
