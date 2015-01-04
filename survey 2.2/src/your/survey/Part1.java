package your.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Part1 extends Activity {
	
	
	ImageButton button1;
	String location;
	
	
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.part1);
		
		button1 = (ImageButton)findViewById(R.id.button1);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		
	    }
	    public void send(View view)
		   {
			
	    	finish();  	  
	    	 Intent i=new Intent(Part1.this,Page1.class);
	    	   i.putExtra("location",location);
	    	   startActivity(i);
	    	   
	    	    	}	
	    @Override
	    public void onBackPressed() {
	   	 
	    }
}
	    

