package co.infinum.pokemon.mvp.presenters;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpListener;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails;

import static co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails.Interactor;
import static co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails.View;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonDetailsPresenter implements MvpPokemonDetails.Presenter, MvpListener<Pokemon> {

    private final View pokemonDetailsView;

    private final Interactor pokemonDetailsInteractor;

    @Inject
    public PokemonDetailsPresenter(View pokemonDetailsView, Interactor pokemonDetailsInteractor) {
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
