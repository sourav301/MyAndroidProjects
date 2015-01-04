package com.example.connect;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button button1,button2;
	 private Handler mHandler = new Handler();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        
        //startService(new Intent(MainActivity.this , Connect_service.class));
        
    }
    
        
    public void Start(View v)
    {
    	startService(new Intent(MainActivity.this , Connect_service.class));
    	//Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
    	
    }

    public void Stop(View v)
    {
    	stopService(new Intent(MainActivity.this , Connect_service.class));
    	//Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
    }

}
