package co.infinum.pokemon.dagger.modules;

import co.infinum.pokemon.data.local.database.Database;
import co.infinum.pokemon.data.local.database.DatabaseImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jmarkovic on 28/05/16.
 */
@Module
public class DatabaseModule {

    @Provides
    public Database provideDatabase() {
        return DatabaseImpl.INSTANCE;
    }

}
