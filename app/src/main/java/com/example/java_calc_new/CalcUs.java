package com.example.java_calc_new;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.VideoView;

public class CalcUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_us);
        int SPLASH_TIME_OUT = 4000;

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(CalcUs.this, CalculatorActivity.class));
                finish();
            }
        },SPLASH_TIME_OUT);

    }


}
