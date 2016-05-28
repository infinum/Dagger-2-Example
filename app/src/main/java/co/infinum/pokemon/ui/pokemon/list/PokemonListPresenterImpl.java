package co.infinum.pokemon.ui.pokemon.list;

import javax.inject.Inject;

import co.infinum.pokemon.data.models.Pokedex;
import co.infinum.pokemon.data.models.Pokemon;
import co.infinum.pokemon.data.interactors.pokemon.list.PokemonListInteractor;
import co.infinum.pokemon.data.interactors.pokemon.list.PokemonListListener;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonListPresenterImpl implements PokemonListPresenter, PokemonListListener {

    private final PokemonListView pokemonListView;

    private final PokemonListInteractor pokemonListInteractor;

    @Inject
    public PokemonListPresenterImpl(PokemonListView pokemonListView, PokemonListInteractor pokemonListInteractor) {
        this.pokemonListView = pokemonListView;
        this.pokemonListInteractor = pokemonListInteractor;

        this.pokemonListInteractor.provideListener(this);
    }

    @Override
    public void loadPokemonList() {
        pokemonListView.showProgress();
        pokemonListInteractor.loadPokemonList();
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
