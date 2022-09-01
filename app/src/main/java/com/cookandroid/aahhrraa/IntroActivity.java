package com.cookandroid.aahhrraa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;
import android.content.Intent;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}