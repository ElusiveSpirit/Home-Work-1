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

    private final String TASK = "adv.android_11.solleks.homework1.TASK";

    WaitAndStart mWAS;


    // TODO Существует ли альтернативный способ решения данного вопроса?
    // Вызывается ли какой-то метод после onResume?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Этот метод исключен с sdk13. Что его заменило?
        mWAS = (WaitAndStart)getLastNonConfigurationInstance();
        if (mWAS == null) {
            mWAS= new WaitAndStart();
            mWAS.execute();
        }
        mWAS.setLink(this);
    }

    public Object onRetainNonConfigurationInstance() {
        mWAS.unLink();
        return mWAS;
    }

    class WaitAndStart extends AsyncTask<Void, Void, Void> {

        IntroActivity activity;

        // получаем ссылку на MainActivity
        void setLink(IntroActivity act) {
            activity = act;
        }

        // обнуляем ссылку
        void unLink() {
            activity = null;
        }

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
