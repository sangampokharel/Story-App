package com.example.dell_i5.story;

import com.google.firebase.database.FirebaseDatabase;

public class firePersistance extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /* Enable disk persistence  */
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
