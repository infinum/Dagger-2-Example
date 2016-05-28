package co.infinum.pokemon.data.interactors.pokemon.details;

import javax.inject.Inject;

import co.infinum.pokemon.data.local.database.Database;
import co.infinum.pokemon.data.models.Pokemon;
import co.infinum.pokemon.data.remote.PokemonService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dino on 21/03/15.
 */
public class PokemonDetailsInteractorImpl implements PokemonDetailsInteractor, Callback<Pokemon> {

    private PokemonDetailsListener pokemonDetailsListener;

    private boolean isCanceled;

    private PokemonService pokemonService;
    private Database database;

    @Inject
    public PokemonDetailsInteractorImpl(PokemonService pokemonService, Database database) {
        this.pokemonService = pokemonService;
        this.database = database;
    }

    @Override
    public void provideListener(PokemonDetailsListener listener) {
        this.pokemonDetailsListener = listener;
    }

    @Override
    public void loadPokemonDetails(String resourceUri) {
        reset();

        final Pokemon pokemon = database.getPokemon(resourceUri);
        if (pokemon == null) {
            pokemonService.getPokemon(resourceUri, this);
        } else {
            this.pokemonDetailsListener.onSuccess(pokemon);
        }
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
            database.storePokemon(pokemon.getResourceUri().substring(1), pokemon);
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
