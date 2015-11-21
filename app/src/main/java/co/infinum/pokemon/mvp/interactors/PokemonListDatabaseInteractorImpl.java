package co.infinum.pokemon.mvp.interactors;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import co.infinum.pokemon.models.Pokedex;
import co.infinum.pokemon.models.Pokemon;
import co.infinum.pokemon.mvp.interactors.impl.RetrofitInteractor;
import co.infinum.pokemon.mvp.listeners.PokemonListListener;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 21/11/15
 */
public class PokemonListDatabaseInteractorImpl extends RetrofitInteractor implements PokemonListInteractor {

    private final PokemonListListener.Source source = PokemonListListener.Source.DATABASE;

    @Override
    public void loadPokemonList(PokemonListListener pokemonListListener) {
        reset();

        List<Pokemon> pokemons = new Select().from(Pokemon.class).queryList();
        pokemonListListener.onSuccess(new Pokedex(pokemons), source);

    }

}
