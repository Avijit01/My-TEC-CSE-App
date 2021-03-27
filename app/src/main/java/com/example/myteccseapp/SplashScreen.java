package com.example.myteccseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    ProgressBar progressBar;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progress();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    public void progress()
    {
        progressBar = (ProgressBar)findViewById(R.id.progressBarId);

        final Timer timer = new Timer();
        TimerTask tTask = new TimerTask() {
            @Override
            public void run()
            {
                counter++;
                progressBar.setProgress(counter);

                if(counter == 100)
                    timer.cancel();
            }
        };

        timer.schedule(tTask,0,40);
    }
}