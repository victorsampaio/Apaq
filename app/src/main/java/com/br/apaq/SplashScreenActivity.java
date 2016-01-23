package com.br.apaq;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity implements Runnable {

    private static final int DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(this, DELAY);
    }

    @Override
    public void run() {
        startActivity(new Intent(getApplicationContext(), ApaqMainActivity.class));
        finish();
    }
}
