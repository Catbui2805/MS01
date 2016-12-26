package com.example.catbui.ms01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ubidots.ApiClient;
import com.ubidots.Variable;

public class ubidot extends AppCompatActivity {


    private BroadcastReceiver mBatteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = 20;
            new ApiUbidots().execute(level);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_ubidot);
//
//
//        mBatteryLevel = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(mBatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        unregisterReceiver(mBatteryReceiver);
        super.onStop();
    }

    public class ApiUbidots extends AsyncTask<Integer, Void, Void> {
        private final String API_KEY = "39cdf23fe9190ab80ff3ebc8615e9fb695c6a81a";
        private final String VARIABLE_ID = "5856b330762542596fe413ad";

        @Override
        protected Void doInBackground(Integer... params) {
            ApiClient apiClient = new ApiClient(API_KEY);
            Variable batteryLevel = apiClient.getVariable(VARIABLE_ID);

            batteryLevel.saveValue(params[0]);
            return null;
        }
    }
}
