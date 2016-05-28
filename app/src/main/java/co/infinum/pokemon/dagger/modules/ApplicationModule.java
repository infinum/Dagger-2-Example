package co.infinum.pokemon.dagger.modules;

import android.content.Context;

import co.infinum.pokemon.PokemonApp;
import co.infinum.pokemon.dagger.qualifiers.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jmarkovic on 28/05/16.
 */
@Module
public class ApplicationModule {

    private PokemonApp pokemonApp;

    public ApplicationModule(PokemonApp pokemonApp) {
        this.pokemonApp = pokemonApp;
    }

    @Provides
    public PokemonApp provideApplication() {
        return this.pokemonApp;
    }

    @Provides
    @ApplicationContext
    public Context provideApplicationContext() {
        return this.pokemonApp.getApplicationContext();
    }
}
