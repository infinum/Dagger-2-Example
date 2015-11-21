package co.infinum.pokemon.mvp.listeners;

import co.infinum.pokemon.models.Pokedex;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonListListener extends BaseListener {

    /**
     * Used to define from where pokemon list was fetched
     */
    enum Source {
        WEB, DATABASE
    }

    void onSuccess(Pokedex pokedex, Source source);
}
