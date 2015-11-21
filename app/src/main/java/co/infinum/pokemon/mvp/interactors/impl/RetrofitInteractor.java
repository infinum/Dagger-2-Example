package co.infinum.pokemon.mvp.interactors.impl;

import co.infinum.pokemon.mvp.interactors.BaseInteractor;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 21/11/15
 */
public class RetrofitInteractor implements BaseInteractor {

    protected boolean isCanceled;

    @Override
    public void cancel() {
        isCanceled = true;
    }

    @Override
    public void reset() {
        isCanceled = false;
    }

}
