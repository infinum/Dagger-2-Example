package co.infinum.pokemon.data.local.database;

import co.infinum.pokemon.data.models.Pokemon;

/**
 * Created by jmarkovic on 28/05/16.
 */
public interface Database {

    void storePokemon(String resourceUri, Pokemon pokemon);

    Pokemon getPokemon(String resourceUri);

}
