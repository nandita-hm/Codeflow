package com.example.codeflow;

import com.firebase.client.Firebase;

public class Database extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
