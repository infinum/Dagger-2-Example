package co.infinum.pokemon.mvp.listeners;

import co.infinum.pokemon.models.Pokemon;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsListener extends BaseListener {

    void onSuccess(Pokemon pokemon);
}
