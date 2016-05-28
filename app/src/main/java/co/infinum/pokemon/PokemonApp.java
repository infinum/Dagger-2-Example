package co.infinum.pokemon;

import android.app.Application;

import co.infinum.pokemon.dagger.components.AppComponent;
import co.infinum.pokemon.dagger.components.DaggerAppComponent;
import co.infinum.pokemon.dagger.modules.ApplicationModule;

public class PokemonApp extends Application {

    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}
