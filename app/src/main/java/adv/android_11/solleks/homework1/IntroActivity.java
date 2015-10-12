package adv.android_11.solleks.homework1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Константин on 08.10.2015.
 *
 *
 */
public class IntroActivity extends Activity {

    IntroActivity introActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Существует ли альтернативный способ решения данного вопроса?
        // Вызывается ли какой-то метод после onResume?
        new WaitAndStart().execute();
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
