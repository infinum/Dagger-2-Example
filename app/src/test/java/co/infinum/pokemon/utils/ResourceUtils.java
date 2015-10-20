package co.infinum.pokemon.utils;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.res.Resources;

import java.io.InputStream;

/**
 * Utility methods for accessing resources bundled with test APK. Standard Android Resources don't seem to work for test APK
 * (unable to fetch R.java).
 * <p>
 * Resources should be placed under /resources/mockdata folder in androidTest flavour. Use {@link #readFromFile(String)} to read a text
 * file to String giving only a name of the file located in /resources folder.
 */
public class ResourceUtils {

    private static final String MOCK_DATA_DIRECTORY = "mockdata/%s";

    /**
     * Converts InputStream to String.
     */
    public static String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


    /**
     *
     * @param packageName
     * @return
     * @throws PackageManager.NameNotFoundException
     */
    protected static Resources getResources(Application application, String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = application.getPackageManager();
        return pm.getResourcesForApplication(packageName);
    }

    /**
     * Reads a resource file to <code>String</code>.
     */
    public static String readFromFile(String filename) {
        InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(String.format(MOCK_DATA_DIRECTORY, filename));
        return convertStreamToString(is);

    }

}
