package co.infinum.pokemon.shadows;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

import android.util.Log;

import java.io.Reader;
import java.lang.reflect.Type;

import static org.robolectric.internal.Shadow.directlyOn;

/**
 * Created by ivan on 20/10/15.
 */
@Implements(Gson.class)
public class ShadowGson {

    /**
     * Real object that will be injected when shadow is constructed.
     */
    @RealObject
    private Gson gson;

    /**
     * Shadowed constructor.
     */
    public void __constructor__() {

    }

    @Implementation
    public <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        //Log that we're deserializing an object.
        Log.d("GsonShadow", "Deserializing " + typeOfT.toString());

        //Use directlyOn to invoke a shadowed method directly on a
        //Real object. Otherwise you'll get stack overflow exception.
        return directlyOn(gson, Gson.class).fromJson(json, typeOfT);
    }
}
