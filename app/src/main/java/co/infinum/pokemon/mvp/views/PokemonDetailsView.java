package co.infinum.pokemon.mvp.views;

import co.infinum.pokemon.models.Pokemon;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsView extends BaseView {

    void showDetails(Pokemon pokemon);
}
