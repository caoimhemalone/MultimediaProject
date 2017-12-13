package com.example.caoimhemalone.multimediaproject;

import android.util.Log;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

/**
 * Created by caoimhemalone on 13/12/2017.
 */

public class AppConfig {
        public static final String connectionString = "jdbc:mysql://mysql2.gear.host/dbstuddybuddy";
    public static final String db_user = "caoimhe";
    public static final String db_pass = "password";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String TABLE_NAME = "restaurants";


}
