package co.infinum.pokemon.mvp.presenters.impl;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interactors.PokemonDetailsInteractor;
import co.infinum.pokemon.mvp.listeners.PokemonDetailsListener;
import co.infinum.pokemon.mvp.presenters.PokemonDetailsPresenter;
import co.infinum.pokemon.mvp.views.PokemonDetailsView;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonDetailsPresenterImpl implements PokemonDetailsPresenter, PokemonDetailsListener {

    private final PokemonDetailsView pokemonDetailsView;

    private final PokemonDetailsInteractor pokemonDetailsInteractor;

    @Inject
    public PokemonDetailsPresenterImpl(PokemonDetailsView pokemonDetailsView, PokemonDetailsInteractor pokemonDetailsInteractor) {
        this.pokemonDetailsView = pokemonDetailsView;
        this.pokemonDetailsInteractor = pokemonDetailsInteractor;
    }

    @Override
    public void loadDetails(Pokemon pokemon) {
        pokemonDetailsView.showProgress();
        pokemonDetailsInteractor.loadPokemonDetails(pokemon.getResourceUri(), this);
    }

    @Override
    public void cancel() {
        pokemonDetailsView.hideProgress();
        pokemonDetailsInteractor.cancel();
    }

    @Override
    public void onSuccess(Pokemon pokemon) {
        pokemonDetailsView.hideProgress();
        pokemonDetailsView.showDetails(pokemon);
    }

    @Override
    public void onFailure(String message) {
        pokemonDetailsView.hideProgress();
        pokemonDetailsView.showError(message);
    }
}
