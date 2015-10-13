package co.infinum.pokemon.helpers;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;

/**
 * Created by zeljkoplesac on 05/02/15.
 */
public class CustomRobolectricGradleTestRunner extends RobolectricGradleTestRunner {

    public CustomRobolectricGradleTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        AndroidManifest appManifest = super.getAppManifest(config);
        appManifest.setPackageName("co.infinum.pokemon"); // needs to be the java package name, not applicationId
        return appManifest;
    }
}