package co.infinum.pokemon.data.interactors.pokemon.details;

import co.infinum.pokemon.data.interactors.BaseListener;
import co.infinum.pokemon.data.models.Pokemon;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsListener extends BaseListener {

    void onSuccess(Pokemon pokemon);
}
