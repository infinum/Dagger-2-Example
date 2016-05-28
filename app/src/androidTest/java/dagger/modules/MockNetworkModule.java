package dagger.modules;

import co.infinum.pokemon.dagger.modules.NetworkModule;
import dagger.Module;

/**
 * Created by dino on 12/05/15.
 */
@Module(includes = {
        MockHostModule.class,
        NetworkModule.class
})
public class MockNetworkModule {

}
