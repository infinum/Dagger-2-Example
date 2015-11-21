package co.infinum.pokemon;

import android.app.Application;

import co.infinum.pokemon.dagger.components.AppComponent;
import co.infinum.pokemon.dagger.components.DaggerAppComponent;

public class PokemonApp extends Application {

    private static PokemonApp instance;

    private AppComponent applicationComponent;

    public static PokemonApp getInstance() {
        return instance;
    }

    public static void setInstance(PokemonApp instance) {
        PokemonApp.instance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);

        applicationComponent = DaggerAppComponent.create();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}
