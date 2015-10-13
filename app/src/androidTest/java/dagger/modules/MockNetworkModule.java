package dagger.modules;

import dagger.Module;

/**
 * Created by dino on 12/05/15.
 */
@Module(includes = {
        MockHostModule.class,
        ApiModule.class
})
public class MockNetworkModule {

}
