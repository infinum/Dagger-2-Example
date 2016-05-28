package co.infinum.pokemon.data.interactors.pokemon.details;

import co.infinum.pokemon.data.interactors.BaseInteractor;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsInteractor extends BaseInteractor<PokemonDetailsListener> {

    void loadPokemonDetails(String resourceUri);
}
