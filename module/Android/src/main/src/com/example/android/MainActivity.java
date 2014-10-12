package com.example.android;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {
    
    @InjectView(R.id.button)
    private Button button;
    
    @InjectView(R.id.message)
    private TextView message;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setText("Hello Android!!");
            }
        });
    }
}
