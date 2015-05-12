package co.infinum.pokemon.mvp.presenters;

import co.infinum.pokemon.models.Pokemon;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsPresenter extends BasePresenter {

    void loadDetails(Pokemon pokemon);
}
