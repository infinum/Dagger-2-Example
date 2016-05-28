package co.infinum.pokemon.background;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by jmarkovic on 29/05/16.
 */

public class WorkerService extends IntentService {

    public WorkerService() {
        super(WorkerService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Intent receiverIntent = new Intent(this, WorkerBroadcastReceiver.class);
        receiverIntent.putExtra("work", "done");
        sendBroadcast(receiverIntent);
    }
}
