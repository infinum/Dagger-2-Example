package co.infinum.pokemon.test.helpers;

import org.mockito.InOrder;

import co.infinum.pokemon.ui.BaseView;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

/**
 * Created by dino on 30/06/14.
 */
public class TestHelper {

    public static final int CALLBACK_TIMEOUT_MS = 1000;

    public static void verifyShowHideProgress(BaseView baseView) {
        verify(baseView, timeout(CALLBACK_TIMEOUT_MS)).hideProgress();
        InOrder inOrder = inOrder(baseView);
        inOrder.verify(baseView).showProgress();
        inOrder.verify(baseView).hideProgress();
    }

    public static <T> T verifyAsync(T mock) {
        return verifyAsync(mock, CALLBACK_TIMEOUT_MS);
    }

    public static <T> T verifyAsync(T mock, long timeoutMillis) {
        return verify(mock, timeout(timeoutMillis));
    }
}
