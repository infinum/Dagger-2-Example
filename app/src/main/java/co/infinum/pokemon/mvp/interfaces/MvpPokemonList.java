package co.infinum.pokemon.mvp.interfaces;

import java.util.List;

import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.listeners.PokemonListListener;

/**
 * Created by Ivan on 16/05/16.
 */
public interface MvpPokemonList {

    interface Interactor extends MvpBase.Interactor {

        void loadPokemonList(PokemonListListener pokemonListListener);
    }

    interface Presenter extends MvpBase.Presenter {

        void loadPokemonList();

        void onPokemonSelected(Pokemon pokemon);
    }

    interface View extends MvpBase.View {

        void showPokemons(List<Pokemon> pokemons);

        void showPokemonDetails(Pokemon pokemon);
    }

}
