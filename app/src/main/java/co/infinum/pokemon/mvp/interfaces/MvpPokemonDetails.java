package co.infinum.pokemon.mvp.interfaces;

import co.infinum.pokemon.models.Pokemon;

/**
 * Created by Ivan on 16/05/16.
 */
public interface MvpPokemonDetails {

    interface Interactor extends MvpBase.Interactor {

        void loadPokemonDetails(String resourceUri, MvpListener<Pokemon> pokemonDetailsListener);

        void loadPokemonDetails(int pokemonId, MvpListener<Pokemon> pokemonDetailsListener);
    }

    interface Presenter extends MvpBase.Presenter {

        void loadDetails(Pokemon pokemon);
    }

    interface View extends MvpBase.View {

        void showName(String name);

        void showHp(String hp);

        void showWeight(String weight);

        void showHeight(String height);

        void showAttack(String attack);

        void showDefense(String defense);
    }
}
