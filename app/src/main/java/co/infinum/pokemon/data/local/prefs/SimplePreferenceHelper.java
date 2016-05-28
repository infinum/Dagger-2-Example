package co.infinum.pokemon.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.infinum.pokemon.dagger.qualifiers.ApplicationContext;

/**
 * Created by jmarkovic on 28/05/16.
 */
@Singleton
public final class SimplePreferenceHelper {

    public static final String KEY_USE_STARTER_POKEMON = "use_starter_pokemon";
    public static final String KEY_FAVORITE_POKEMON = "favorite_pokemon";

    private static final String FILE_NAME_SETTINGS = "settings.prefs";

    private final SharedPreferences prefs;

    @Inject
    public SimplePreferenceHelper(@ApplicationContext @NonNull Context context) {
        this.prefs = context.getSharedPreferences(FILE_NAME_SETTINGS, Context.MODE_PRIVATE);
    }
}
