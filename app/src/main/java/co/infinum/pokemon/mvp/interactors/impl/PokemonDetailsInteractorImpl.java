package co.infinum.pokemon.mvp.interactors.impl;

import co.infinum.pokemon.core.Core;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interactors.PokemonDetailsInteractor;
import co.infinum.pokemon.mvp.listeners.PokemonDetailsListener;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonDetailsInteractorImpl implements PokemonDetailsInteractor, Callback<Pokemon> {

    private PokemonDetailsListener pokemonDetailsListener;

    private boolean isCanceled;

    @Override
    public void loadPokemonDetails(String resourceUri, PokemonDetailsListener pokemonDetailsListener) {
        reset();
        this.pokemonDetailsListener = pokemonDetailsListener;
        Core.getCore().getPokemonService().getPokemon(resourceUri, this);
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
    public void success(Pokemon pokemon, Response response) {
        if (!isCanceled) {
            pokemonDetailsListener.onSuccess(pokemon);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        if (!isCanceled) {
            pokemonDetailsListener.onFailure(error.getMessage());
        }
    }
}
