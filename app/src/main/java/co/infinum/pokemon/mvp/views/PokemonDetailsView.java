package co.infinum.pokemon.mvp.views;

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
