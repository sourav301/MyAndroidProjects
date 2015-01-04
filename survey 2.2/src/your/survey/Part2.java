package your.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Part2 extends Activity {
	
	
	ImageButton button1;
	String location;
	int count=0;
	
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.part2);
		
		button1 = (ImageButton)findViewById(R.id.button1);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    }
	    public void send(View view)
		   {
			
	    	finish();  	  
	    	 Intent i=new Intent(Part2.this,Page11.class);
	    	   i.putExtra("location",location);
	    	   i.putExtra("count",count);
	    	   startActivity(i);
	    	   
	    	   
	    	    	}	
	    @Override
	    public void onBackPressed() {
	   	 
	    }
}
	    

