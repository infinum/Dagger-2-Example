package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.PokemonApp;
import co.infinum.pokemon.network.PokemonService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dino on 12/05/15.
 */
@Module
public class NetworkModule {

    @Provides
    public PokemonService providePokemonService() {
        return PokemonApp.getInstance().getPokemonService();
    }
}
