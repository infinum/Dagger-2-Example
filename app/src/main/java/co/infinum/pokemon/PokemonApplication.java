package co.infinum.pokemon;

import android.app.Application;

public class PokemonApplication extends Application {

    private static PokemonApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static PokemonApplication getInstance() {
        return instance;
    }
}
