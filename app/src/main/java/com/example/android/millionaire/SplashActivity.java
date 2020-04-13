package com.example.android.millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;


//this is the class for the splash screen
public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(3000);

                        Intent login = new Intent(SplashActivity.this, SelectActivity.class);
                        startActivity(login);
                        finish();
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                } catch (InterruptedException ex) {

                }
            }
        }.start();
    }
}