package co.infinum.pokemon.test.dagger.modules;

import dagger.Module;

/**
 * Created by dino on 12/05/15.
 */
@Module(includes = {
        HostModule.class,
        ApiModule.class
})
public class NetworkModule {

}
