package com.example.android;

import java.util.List;

import javax.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import roboguice.util.Ln;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.db.MyDaoProvider;
import com.example.android.db.SampleTable;
import com.j256.ormlite.dao.RuntimeExceptionDao;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {
    
    @InjectView(R.id.button)
    private Button button;
    
    @InjectView(R.id.message)
    private TextView message;
    
    @Inject
    private MyDaoProvider daoProvider;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setText("Hello Android!!");
            }
        });
        
        RuntimeExceptionDao<SampleTable, Long> dao = this.daoProvider.getSampleTableDao();
        List<SampleTable> list = dao.queryForAll();
        
        for (SampleTable s : list) {
            Ln.v(s);
        }
    }
}
