package co.infinum.pokemon;

import android.app.Application;

import javax.inject.Inject;

import co.infinum.pokemon.network.PokemonService;
import dagger.components.DaggerAppComponent;

public class PokemonApp extends Application {

    private static PokemonApp instance;

    @Inject
    protected PokemonService pokemonService;

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);

        DaggerAppComponent.create().inject(this);
    }

    public static void setInstance(PokemonApp instance) {
        PokemonApp.instance = instance;
    }

    public static PokemonApp getInstance() {
        return instance;
    }

    public PokemonService getPokemonService() {
        return pokemonService;
    }
}
