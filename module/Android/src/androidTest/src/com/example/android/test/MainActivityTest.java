package com.example.android.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.MainActivity;
import com.example.android.R;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }
    
    private Activity activity;
    private Button button;
    private TextView message;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        activity = getActivity();
        button = (Button)activity.findViewById(R.id.button);
        message = (TextView)activity.findViewById(R.id.message);
    }
    
    
    public void test() throws Exception {
        // exercise
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        });

        getInstrumentation().waitForIdleSync();
        
        // verify
        assertEquals(message.getText(), "Hello Android Project!!");
    }
}
