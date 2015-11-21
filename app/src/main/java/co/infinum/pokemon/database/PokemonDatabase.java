package co.infinum.pokemon.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 21/11/15
 */
@Database(name = PokemonDatabase.NAME, version = PokemonDatabase.VERSION)
public class PokemonDatabase {

    public static final String NAME = "Pokemons";

    public static final int VERSION = 1;

}
