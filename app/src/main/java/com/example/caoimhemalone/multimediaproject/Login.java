package com.example.caoimhemalone.multimediaproject;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by caoimhemalone on 13/12/2017.
 */

@IgnoreExtraProperties
public class Login {
    public String name;
    public String email;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Login() {
    }

    public Login(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
