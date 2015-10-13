package co.infinum.pokemon.helpers;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Utility methods for accessing resources bundled with test APK. Standard Android Resources don't seem to work for test APK
 * (unable to fetch R.java).
 * <p>
 * Resources should be placed under /resources/mockdata folder in androidTest flavour. Use {@link #readFromFile(String)} to read a text
 * file to String giving only a name of the file located in /resources/mockdata folder.
 */
public class ResourceUtils {

    private static final String MOCK_DATA_DIRECTORY = "mockdata/%s";

    private ResourceUtils() {
    }

    /**
     * Converts InputStream to String.
     */
    public static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is, "UTF-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * Reads a resource file to <code>String</code>.
     */
    public static String readFromFile(String filename) {
        InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(String.format(MOCK_DATA_DIRECTORY, filename));
        return convertStreamToString(is);
    }
}
