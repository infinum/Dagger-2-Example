package co.infinum.pokemon.mvp.presenters;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import android.text.TextUtils;

import java.util.List;

import javax.inject.Inject;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interfaces.MvpListener;
import co.infinum.pokemon.mvp.interfaces.MvpPokedex;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonDetails;
import co.infinum.pokemon.mvp.interfaces.MvpPokemonList;

/**
 * Created by Ivan on 16/05/16.
 */
public class PokedexPresenter implements MvpPokedex.Presenter, MvpListener<Pokedex> {

    private static final String UKNOWN_NAME = "???";

    private MvpPokemonDetails.Interactor detailsInteractor;

    private MvpPokedex.View view;

    private Gson gson;

    private MvpPokedex.Interactor pokedexInteractor;

    private MvpPokemonList.Interactor pokemonListInteractor;

    private List<Pokemon> pokemons;

    @Inject
    public PokedexPresenter(MvpPokedex.Interactor pokedexInteractor, MvpPokemonList.Interactor pokemonListInteractor,
            MvpPokemonDetails.Interactor detailsInteractor, MvpPokedex.View view) {
        this.pokedexInteractor = pokedexInteractor;
        this.pokemonListInteractor = pokemonListInteractor;
        this.detailsInteractor = detailsInteractor;
        this.view = view;
        this.gson = new Gson();
    }

    @Override
    public void loadPokedex() {
        view.showProgress();
        pokemonListInteractor.loadPokemonList(this);
    }

    @Override
    public void onPokemonSelected(Pokemon pokemon) {
        if (!TextUtils.equals(pokemon.getName(), UKNOWN_NAME)) {
            view.showPokemonDetails(pokemon);
        }
    }

    @Override
    public void addPokemon(String contents) {
        // Try to parse the pokemon model

        try {
            Pokemon pokemon = gson.fromJson(contents, Pokemon.class);
            if (pokedexInteractor.addPokemon(pokemon)) {
                view.newPokemon(pokemon);
            } else {
                view.showPokemonDetails(pokemon);
            }

        } catch (JsonSyntaxException e) {
            // generate random integer from content
            int pokemonId = contents.hashCode() % 151;
            detailsInteractor.loadPokemonDetails(pokemonId, new MvpListener<Pokemon>() {

                @Override
                public void onSuccess(Pokemon pokemon) {
                    if (pokedexInteractor.addPokemon(pokemon)) {
                        view.newPokemon(pokemon);
                    } else {
                        view.showPokemonDetails(pokemon);
                    }
                }

                @Override
                public void onFailure(String message) {

                }
            });
        }
    }

    @Override
    public void cancel() {
        pokemonListInteractor.cancel();
    }

    @Override
    public void onSuccess(Pokedex pokedex) {
        if (pokemons == null) {
            pokemons = pokedex.getPokemons();
            pokedexInteractor.loadKnownPokemonList(this);
        } else {
            for (Pokemon pokemon : pokemons) {
                if (!pokedex.getPokemons().contains(pokemon)) {
                    pokemon.setName(UKNOWN_NAME);
                }
            }
            view.hideProgress();
            view.showPokemons(pokemons);
        }

    }

    @Override
    public void onFailure(String message) {
        view.hideProgress();
    }
}
