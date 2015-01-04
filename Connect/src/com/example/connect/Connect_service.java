package com.example.connect;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Connect_service extends Service{

	//Timer timer = new Timer();
    //TimerTask updateProfile = new CustomTimerTask(Connect_service.this);
   
	public void onCreate() {
		// TODO Auto-generated method stub
		
		super.onCreate();
		Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
		
        //timer.scheduleAtFixedRate(updateProfile, 0, 50000);
		checknet();
		
	}
	
	TimerTask scanTask;
	final Handler handler = new Handler();
	Timer t = new Timer();

	public void checknet(){

	scanTask = new TimerTask() {
	        public void run() {
	                handler.post(new Runnable() {
	                        public void run() {
	                        	ConnectivityManager connectivityManager 
	                 	       = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	                 	       NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	                 	       
	                 	       if (activeNetworkInfo == null){
	                 	       Toast.makeText(Connect_service.this,  "No Internet Connection",    Toast.LENGTH_LONG).show();
	                 	       }else{
	                 	        if (activeNetworkInfo.isConnected()){
	                 	           Toast.makeText(Connect_service.this,  "Internet is Connected",    Toast.LENGTH_LONG).show();
	                 	           }else if (activeNetworkInfo.isConnectedOrConnecting()){
	                 	            Toast.makeText(Connect_service.this, "Connecting",   Toast.LENGTH_LONG).show();
	                 	           }
	                 	       }
	                        }
	               });
	        }};


	    t.scheduleAtFixedRate(scanTask, 0, 5000); 

	 }


	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
		t.cancel();
	}



	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
