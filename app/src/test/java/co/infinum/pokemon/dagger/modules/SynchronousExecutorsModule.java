package co.infinum.pokemon.dagger.modules;

import java.util.concurrent.Executor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * This module uses to inject HTTP Client
 * and Callback executors. This implementation of Executors run the HTTP Client requests and
 * Callbacks on the same thread as the caller.
 * <p>
 * Beware as this should be used only for testing purposes, running on a device will result in
 * {@link android.os.NetworkOnMainThreadException}.
 */
@Module
public class SynchronousExecutorsModule {

    class SynchronousExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    @Provides
    @Named("HttpExecutor")
    public Executor provideHttpExecutor() {
        return new SynchronousExecutor();
    }

    @Provides
    @Named("CallbackExecutor")
    public Executor provideCallbackExecutor() {
        return new SynchronousExecutor();
    }
}
