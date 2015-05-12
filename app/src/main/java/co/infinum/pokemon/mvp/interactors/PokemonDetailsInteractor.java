package co.infinum.pokemon.mvp.interactors;

import co.infinum.pokemon.mvp.listeners.PokemonDetailsListener;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsInteractor extends BaseInteractor {

    void loadPokemonDetails(String resourceUri, PokemonDetailsListener pokemonDetailsListener);
}
