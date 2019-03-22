package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.Response;

public class HelloWorldActivity extends AppCompatActivity {

    private static final String TAG = "HelloWorldActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);
        Log.d(TAG, "onCreate execute");
        this.textView = (TextView)findViewById(R.id.abc);

        String weatherId = "CN101020200";

        String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId + "&key=102b365ce560434fbb06a5268e492069";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final String responseText = response.body().string();
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       textView.setText(responseText);
                   }
               });

            }

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }
        });
    }
    }
