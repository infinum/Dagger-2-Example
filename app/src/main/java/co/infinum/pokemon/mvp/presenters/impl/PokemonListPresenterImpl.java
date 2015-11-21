package co.infinum.pokemon.mvp.presenters.impl;

import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.runtime.transaction.process.SaveModelTransaction;
import com.raizlabs.android.dbflow.sql.language.Delete;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.listeners.PokemonListListener;
import co.infinum.pokemon.mvp.presenters.PokemonListPresenter;
import co.infinum.pokemon.mvp.views.PokemonListView;

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
    public void onSuccess(Pokedex pokedex, Source source) {

        if (source.equals(Source.WEB)) {

            //Since no user generated content is saved in Pokemon database (favorites etc.) the whole table can be deleted
            Delete.table(Pokemon.class);
            TransactionManager.getInstance().addTransaction(new SaveModelTransaction<>(ProcessModelInfo.withModels(pokedex.getPokemons())));

        }


        pokemonListView.hideProgress();
        pokemonListView.showPokemons(pokedex.getPokemons());
    }

    @Override
    public void onFailure(String message) {
        pokemonListView.hideProgress();
        pokemonListView.showError(message);
    }
}
