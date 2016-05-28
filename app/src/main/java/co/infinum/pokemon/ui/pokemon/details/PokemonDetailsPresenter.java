package co.infinum.pokemon.ui.pokemon.details;

import co.infinum.pokemon.data.models.Pokemon;
import co.infinum.pokemon.ui.BasePresenter;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsPresenter extends BasePresenter {

    void loadDetails(Pokemon pokemon);
}
