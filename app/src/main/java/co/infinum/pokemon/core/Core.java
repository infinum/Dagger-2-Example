package co.infinum.pokemon.core;

import javax.inject.Inject;

import co.infinum.pokemon.network.PokemonService;
import co.infinum.pokemon.test.dagger.components.DaggerCoreComponent;
import co.infinum.pokemon.test.dagger.modules.ApiModule;
import co.infinum.pokemon.test.dagger.modules.HostModule;
import co.infinum.pokemon.test.dagger.modules.NetworkModule;

/**
 * Created by ivan on 12/10/15.
 */
public class Core {

    private static Core core;

    private PokemonService pokemonService;

    @Inject
    Core(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public static void inject() {
        core = DaggerCoreComponent.builder()
                .networkModule(new NetworkModule())
                .build()
                .inject();
    }

    public static void inject(Core core) {
        Core.core = core;
    }

    public static Core getCore() {
        return core;
    }

    public PokemonService getPokemonService() {
        return pokemonService;
    }
}
