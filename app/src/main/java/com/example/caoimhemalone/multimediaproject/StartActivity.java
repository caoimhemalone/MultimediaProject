package com.example.caoimhemalone.multimediaproject;

/**
 * Created by caoimhemalone on 21/11/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
        
    }
}
