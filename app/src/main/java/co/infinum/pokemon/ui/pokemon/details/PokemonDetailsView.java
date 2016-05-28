package co.infinum.pokemon.ui.pokemon.details;

import co.infinum.pokemon.ui.BaseView;

/**
 * Created by dino on 21/03/15.
 */
public interface PokemonDetailsView extends BaseView {

    void showName(String name);

    void showHp(String hp);

    void showWeight(String weight);

    void showHeight(String height);

    void showAttack(String attack);

    void showDefense(String defense);
}
