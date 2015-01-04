package your.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class SplashScreenActivity extends Activity{
	
	
	 public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.splash);
	
			
			 try { 
					Thread.currentThread();
					Thread.sleep(5000); }
				catch ( Exception e ) { }   

			 
			  
	 }
	
	 public boolean onTouchEvent(MotionEvent event) {
	        if (event.getAction() == MotionEvent.ACTION_DOWN) {
	        	Intent i=new Intent(SplashScreenActivity.this,Startpage.class);
				   startActivity(i);
	            }
	    
	        return true;
	 }
}