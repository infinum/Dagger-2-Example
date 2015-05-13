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
        // APIs are not to be trusted so we wrap interaction with data from API in try/catch
        try {
            pokemonDetailsView.showName(pokemon.getName());
            pokemonDetailsView.showHp(String.valueOf(pokemon.getHp()));
            pokemonDetailsView.showWeight(pokemon.getWeight());
            pokemonDetailsView.showHeight(pokemon.getHeight());
            pokemonDetailsView.showAttack(String.valueOf(pokemon.getAttack()));
            pokemonDetailsView.showDefense(String.valueOf(pokemon.getDefense()));
        } catch (Exception e) {
            e.printStackTrace();
            pokemonDetailsView.showError("Unknown error while using data from API!");
        } finally {
            pokemonDetailsView.hideProgress();
        }
    }

    @Override
    public void onFailure(String message) {
        pokemonDetailsView.hideProgress();
        pokemonDetailsView.showError(message);
    }
}
