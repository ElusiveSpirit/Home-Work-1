package adv.android_11.solleks.homework1;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by Константин on 08.10.2015.
 *
 *
 */
public class IntroActivity extends Activity {

    WaitAndStart task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        task = new WaitAndStart();
        task.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (task.getStatus() == AsyncTask.Status.RUNNING)
            task.cancel(false);
    }

    class WaitAndStart extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setContentView(R.layout.activity_intro);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}
