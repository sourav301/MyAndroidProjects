package com.example.mylocation;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{

	Handler calchandel = new Handler();
	LocationManager mLocationManager;
	TextView show,showplace;
	Location mLocation;
	Button button1;
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
		calculate();
		
		}
	public void refresh(View v)
	{
		show.setText("Refreshing..");
		showplace.setText("Refreshing..");

    calchandel.postDelayed(new Runnable() {
			
			public void run() {
				
				calculate();
				
			}
		}, 1000);
		
		
		
	}
	void calculate()
	{
		show = (TextView) findViewById(R.id.show);
		showplace = (TextView) findViewById(R.id.showplace);
		button1=(Button)findViewById(R.id.button1);
		
		showplace.setText("Welcome to Location Viewer");
		showplace.setText("Welcome to Location Viewer");
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		
		Criteria criteria = new Criteria(); 
		criteria.setAccuracy(Criteria.ACCURACY_FINE); 
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		String locationprovider = mLocationManager.getBestProvider(criteria,true);
				mLocation =	mLocationManager.getLastKnownLocation(locationprovider);
				
				show.setText("\nLatitude: "+mLocation.getLatitude()+
							"\nLongitude: "+mLocation.getLongitude());
				
				
				List<Address> addresses; 
				try {
				Geocoder mGC = new Geocoder(this, Locale.ENGLISH); 
				addresses = mGC.getFromLocation(mLocation.getLatitude(),
				mLocation.getLongitude(), 1); 
				
				if(addresses != null) {
				Address currentAddr = addresses.get(0);
				StringBuilder mSB = new StringBuilder("Address:\n"); 
				for(int i=0; i<currentAddr.getMaxAddressLineIndex(); i++) {
				mSB.append(currentAddr.getAddressLine(i)).append("\n"); 
				}
				showplace.setText(mSB.toString()); 
				}
				} catch(IOException e) { 
					showplace.setText(e.getMessage());
				} 
	}
}