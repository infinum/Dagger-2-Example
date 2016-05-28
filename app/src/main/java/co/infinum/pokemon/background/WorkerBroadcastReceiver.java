package co.infinum.pokemon.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by jmarkovic on 29/05/16.
 */

public class WorkerBroadcastReceiver extends BroadcastReceiver {

    private WorkerListener workerListener;

    public WorkerBroadcastReceiver(WorkerListener workerListener) {
        this.workerListener = workerListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            workerListener.onWorkDone();
        }
    }
}
