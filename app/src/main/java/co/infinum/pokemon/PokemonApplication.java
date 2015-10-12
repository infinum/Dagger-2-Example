package co.infinum.pokemon;

import android.app.Application;

import co.infinum.pokemon.core.Core;

public class PokemonApplication extends Application {

    private static PokemonApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Core.inject();
    }

    public static PokemonApplication getInstance() {
        return instance;
    }
}
