package co.infinum.pokemon;

import com.raizlabs.android.dbflow.config.FlowManager;

import android.app.Application;

import javax.inject.Inject;

import co.infinum.pokemon.dagger.components.DaggerAppComponent;
import co.infinum.pokemon.network.PokemonService;

public class PokemonApp extends Application {

    private static PokemonApp instance;

    @Inject
    protected PokemonService pokemonService;

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        FlowManager.init(this);
        DaggerAppComponent.create().inject(this);
    }

    public static void setInstance(PokemonApp instance) {
        PokemonApp.instance = instance;
    }

    public static PokemonApp getInstance() {
        return instance;
    }

    public void injectPokemonService(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public PokemonService getPokemonService() {
        return pokemonService;
    }
}
