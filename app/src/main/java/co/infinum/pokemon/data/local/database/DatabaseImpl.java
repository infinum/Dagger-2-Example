package co.infinum.pokemon.data.local.database;

import android.support.v4.util.ArrayMap;

import java.util.Map;

import co.infinum.pokemon.data.models.Pokemon;

/**
 * Created by jmarkovic on 28/05/16.
 */
public enum DatabaseImpl implements Database {

    INSTANCE;

    private Map<String, Pokemon> store = new ArrayMap<>();

    @Override
    public void storePokemon(String resourceUri, Pokemon pokemon) {
        store.put(resourceUri, pokemon);
    }

    @Override
    public Pokemon getPokemon(String resourceUri) {
        return store.get(resourceUri);
    }
}
