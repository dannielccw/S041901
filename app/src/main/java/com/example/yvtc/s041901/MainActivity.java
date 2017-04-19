package com.example.yvtc.s041901;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTask m = new MyTask();
        m.execute(5); //dan.w: 5 sec
    }

    class MyTask extends AsyncTask<Integer, Integer, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("MTA", "onPreExecute");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("MTA", "onPostExecute:" + s);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("MTA", "onProgressUpdate:" + values[0]);
        }

        @Override
        protected String doInBackground(Integer... params) {
            int t =params[0];
            int i;

            for (i=1; i<=t; i++)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return "OK";
        }
    }
}
