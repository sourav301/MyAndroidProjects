package your.survey;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Agreement extends Activity {
	
	String location;
	ImageButton na,ha;
	
	
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agreement);
		
		na=(ImageButton)findViewById(R.id.na);
		ha=(ImageButton)findViewById(R.id.ha);
	    }
	    public void send (View v)
	    {
	    	
	    	
	    	if(v.getId()==R.id.ha)
	    	{
	    		finish();
	    		Intent intent = new Intent(this,Name.class);
	    		startActivity(intent);
	    		
	    	}
	    	else if(v.getId()==R.id.na)
	    	{	
	    		finish();
	    		startActivity(new Intent(this,Startpage.class));

	    	}
	    	
	    	
	    }
	  
	}