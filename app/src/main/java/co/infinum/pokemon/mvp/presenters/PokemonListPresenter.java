package co.infinum.pokemon.mvp.presenters;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonList;
import co.infinum.pokemon.mvp.listeners.PokemonListListener;

import static co.infinum.pokemon.mvp.interfaces.MvpPokemonList.*;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonListPresenter implements MvpPokemonList.Presenter, PokemonListListener {

    private final View pokemonListView;

    private final Interactor pokemonListInteractor;

    @Inject
    public PokemonListPresenter(View pokemonListView, Interactor pokemonListInteractor) {
        this.pokemonListView = pokemonListView;
        this.pokemonListInteractor = pokemonListInteractor;
    }

    @Override
    public void loadPokemonList() {
        pokemonListView.showProgress();
        pokemonListInteractor.loadPokemonList(this);
    }

    @Override
    public void onPokemonSelected(Pokemon pokemon) {
        pokemonListView.showPokemonDetails(pokemon);
    }

    @Override
    public void cancel() {
        pokemonListView.hideProgress();
        pokemonListInteractor.cancel();
    }

    @Override
    public void onSuccess(Pokedex pokedex) {
        pokemonListView.hideProgress();
        pokemonListView.showPokemons(pokedex.getPokemons());
    }

    @Override
    public void onFailure(String message) {
        pokemonListView.hideProgress();
        pokemonListView.showError(message);
    }
}
