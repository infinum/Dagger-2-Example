package co.infinum.pokemon.mvp.listeners;

import co.infinum.pokemon.models.Pokedex;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListListener extends BaseListener {

    void onSuccess(Pokedex pokedex);
}
