package com.example.android.db;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.android.ContextHolder;

import roboguice.util.Ln;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;

public class MyDatabaseOpenHelper extends OrmLiteSqliteOpenHelper {
    
    public static final String DATABASE_NAME = "sample.db";
    private static final int DATABASE_VERSION = 1;
    private RuntimeExceptionDao<SampleTable, Long> sampleTableDao;
    
    public MyDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
        SQLiteDatabase db = getWritableDatabase();
        ContextHolder.setContext(context.getApplicationContext());
        
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:sqlite:" + db.getPath(), "", "");
        flyway.migrate();
        
        Ln.v("migrate database.");
        
        db.close();
    }

    public RuntimeExceptionDao<SampleTable, Long> getSampleTableDao() {
        if (this.sampleTableDao == null) {
            this.sampleTableDao = this.getRuntimeExceptionDao(SampleTable.class);
        }

        return this.sampleTableDao;
    }

    @Override public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {/*no use*/}
    @Override public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2, int arg3) {/*no use*/}
}
