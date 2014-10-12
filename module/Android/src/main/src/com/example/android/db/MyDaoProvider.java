package com.example.android.db;

import javax.inject.Inject;

import roboguice.activity.event.OnCreateEvent;
import roboguice.activity.event.OnDestroyEvent;
import roboguice.event.Observes;
import roboguice.util.Ln;
import android.app.Activity;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MyDaoProvider {
    
    @Inject
    private Activity activity;
    
    private MyDatabaseOpenHelper helper;
    private RuntimeExceptionDao<SampleTable, Long> sampleTableDao;

    public void onActivityCreate(@Observes OnCreateEvent event) {
        this.helper = OpenHelperManager.getHelper(this.activity, MyDatabaseOpenHelper.class);
        Ln.v("MyDatabaseOpeHelperProvider.onActivityCreate()");
    }

    public void onActivityDestroy(@Observes OnDestroyEvent event) {
        OpenHelperManager.releaseHelper();
        Ln.v("MyDatabaseOpeHelperProvider.onActivityDestroy()");
    }

    public RuntimeExceptionDao<SampleTable, Long> getSampleTableDao() {
        if (this.sampleTableDao == null) {
            this.sampleTableDao = this.helper.getRuntimeExceptionDao(SampleTable.class);
        }

        return this.sampleTableDao;
    }
}
