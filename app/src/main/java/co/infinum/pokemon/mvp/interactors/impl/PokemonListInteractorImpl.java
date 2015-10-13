package co.infinum.pokemon.mvp.interactors.impl;

import co.infinum.pokemon.core.Core;
import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.listeners.PokemonListListener;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonListInteractorImpl implements PokemonListInteractor, Callback<Pokedex> {

    private PokemonListListener pokemonListListener;

    private boolean isCanceled;

    @Override
    public void loadPokemonList(PokemonListListener pokemonListListener) {
        reset();
        this.pokemonListListener = pokemonListListener;
        Core.getCore().getPokemonService().getPokedex(this);
    }

    @Override
    public void cancel() {
        isCanceled = true;
    }

    @Override
    public void reset() {
        isCanceled = false;
    }

    @Override
    public void success(Pokedex pokedex, Response response) {
        if (!isCanceled) {
            pokemonListListener.onSuccess(pokedex);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        if (!isCanceled) {
            pokemonListListener.onFailure(error.getMessage());
        }
    }
}
