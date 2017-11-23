package com.example.caoimhemalone.multimediaproject;

/**
 * Created by caoimhemalone on 21/11/2017.
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import static com.example.caoimhemalone.multimediaproject.R.layout.activity_start;

public class StartActivity extends AppCompatActivity {


    GifView gifView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();

        //For Gif
        gifView = (GifView) findViewById(R.id.gif_view);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }

        }, 4000L);






    }
}
