package com.example.android;

import roboguice.inject.ContextSingleton;
import android.util.Log;

import com.example.android.db.MyDaoProvider;
import com.example.android.domain.MyDomain;
import com.example.android.domain.MyInterface;
import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {

    @Override
    protected void configure() {
        Log.v("com.example.android", "initialize roboguice container");
        
        bind(MyInterface.class).to(MyDomain.class);
        bind(MyDaoProvider.class).in(ContextSingleton.class);
    }
}
