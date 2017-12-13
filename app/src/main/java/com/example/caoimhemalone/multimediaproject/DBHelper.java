package com.example.caoimhemalone.multimediaproject;

/**
 * Created by caoimhemalone on 13/12/2017.
 */

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBHelper {
    private Connection conn;
    private String TAG = DBHelper.class.getSimpleName();

    public DBHelper() {
        conn = null;
        try {
            Class.forName(AppConfig.DRIVER);
            conn = DriverManager.getConnection(AppConfig.connectionString, AppConfig.db_user, AppConfig.db_pass);
            createTable();
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        } catch (ClassNotFoundException c) {
            Log.e(TAG, c.getMessage());
        }
    }

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS " + AppConfig.TABLE_NAME + "(id int PRIMARY KEY auto_increment, " + "fName varchar(50)not null, " + "lName varchar(50)not null, " + "studentNum varchar(50) not null, " + "email varchar(50) not null, " + "repeatEmail varchar(50) not null, " + "password varchar(50) not null, " + "repeatPassword varchar(50) not null);";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        }
    }

}
