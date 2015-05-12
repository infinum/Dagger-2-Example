package co.infinum.pokemon.mvp.interactors;

import co.infinum.pokemon.mvp.listeners.PokemonListListener;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListInteractor extends BaseInteractor {

    void loadPokemonList(PokemonListListener pokemonListListener);
}
