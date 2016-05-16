package co.infinum.pokemon.mvp.presenters;

import android.text.TextUtils;

import java.util.List;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpListener;
import co.infinum.pokemon.mvp.interfaces.MvpPokedex;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonList;

/**
 * Created by Ivan on 16/05/16.
 */
public class PokedexPresenter implements MvpPokedex.Presenter, MvpListener<Pokedex> {

    private static final String UKNOWN_NAME = "???";

    private MvpPokedex.View view;

    private MvpPokedex.Interactor pokedexInteractor;

    private MvpPokemonList.Interactor pokemonListInteractor;

    private List<Pokemon> pokemons;

    @Inject
    public PokedexPresenter(MvpPokedex.Interactor pokedexInteractor, MvpPokemonList.Interactor pokemonListInteractor,
            MvpPokedex.View view) {
        this.pokedexInteractor = pokedexInteractor;
        this.pokemonListInteractor = pokemonListInteractor;
        this.view = view;
    }

    @Override
    public void loadPokedex() {
        view.showProgress();
        pokemonListInteractor.loadPokemonList(this);
    }

    @Override
    public void onPokemonSelected(Pokemon pokemon) {
        if (!TextUtils.equals(pokemon.getName(), UKNOWN_NAME)) {
            view.showPokemonDetails(pokemon);
        }
    }

    @Override
    public void cancel() {
        pokemonListInteractor.cancel();
    }

    @Override
    public void onSuccess(Pokedex pokedex) {
        if (pokemons == null) {
            pokemons = pokedex.getPokemons();
            pokedexInteractor.loadKnownPokemonList(this);
        } else {
            for (Pokemon pokemon : pokemons) {
                if (!pokedex.getPokemons().contains(pokemon)) {
                    pokemon.setName(UKNOWN_NAME);
                }
            }
            view.hideProgress();
            view.showPokemons(pokemons);
        }

    }

    @Override
    public void onFailure(String message) {

    }
}
