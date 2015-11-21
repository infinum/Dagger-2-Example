package co.infinum.pokemon.mvp.interactors.impl;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.mvp.interactors.PokemonListInteractor;
import co.infinum.pokemon.mvp.listeners.PokemonListListener;
import co.infinum.pokemon.network.PokemonService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonListInteractorImpl extends RetrofitInteractor implements PokemonListInteractor, Callback<Pokedex> {

    private final PokemonListListener.Source SOURCE = PokemonListListener.Source.WEB;

    private PokemonListListener pokemonListListener;

    private PokemonService pokemonService;

    @Inject
    public PokemonListInteractorImpl(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Override
    public void loadPokemonList(PokemonListListener pokemonListListener) {
        reset();
        this.pokemonListListener = pokemonListListener;
        pokemonService.getPokedex(this);
    }

    @Override
    public void success(Pokedex pokedex, Response response) {
        if (!isCanceled) {
            pokemonListListener.onSuccess(pokedex, SOURCE);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        if (!isCanceled) {
            pokemonListListener.onFailure(error.getMessage());
        }
    }
}
