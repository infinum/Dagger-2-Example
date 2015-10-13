package co.infinum.pokemon.test.dagger.components;

import co.infinum.pokemon.core.Core;
import co.infinum.pokemon.test.dagger.modules.NetworkModule;
import dagger.Component;

/**
 * Created by ivan on 12/10/15.
 */
@Component(modules = NetworkModule.class)
public interface TestCoreComponent {

    Core inject();
}
