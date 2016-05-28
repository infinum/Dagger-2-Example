package co.infinum.pokemon.data.interactors.pokemon.list;

import co.infinum.pokemon.data.interactors.BaseInteractor;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListInteractor extends BaseInteractor<PokemonListListener> {

    void loadPokemonList();
}
