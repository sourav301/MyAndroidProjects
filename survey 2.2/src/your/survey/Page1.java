package your.survey;

import java.io.File;
import java.io.FileWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Page1 extends Activity {
	
	String location;
	ImageButton submit1;
	RadioButton q1_1radio,q1_2radio,q1_3radio;
	String mode="";
	int count=0; 
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page1);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		
	    submit1 = (ImageButton)findViewById(R.id.submit1);
	    q1_1radio = (RadioButton)findViewById(R.id.q1_1radio);
	    q1_2radio = (RadioButton)findViewById(R.id.q1_2radio);
	    q1_3radio = (RadioButton)findViewById(R.id.q1_3radio);
	   
	    
	    q1_1radio.setOnClickListener(answer);
	    q1_2radio.setOnClickListener(answer);
	    q1_3radio.setOnClickListener(answer);
	   
	    
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q1_1radio.isChecked())
		  {
			  mode="1.a ";
		  }
		  else if(q1_2radio.isChecked())
		  {
			  mode="1.b ";
		  }
		  else if(q1_3radio.isChecked())
		  {
			  mode="1.c ";
		  }
		  else
		  {
			  mode="Skipped";
		  }
		 
	  }
 };
	    
	    

 public void send(View v)  
	{
		 
	 
	 if(mode.length()<1)
	 {
		 Toast.makeText(getBaseContext(),"SELECT ANSWER",Toast.LENGTH_SHORT).show();
	 }
	 else{
		 
	 try {
		 	File myFile = new File("/sdcard/SURVEY/"+location+"/answers.txt");
		 	FileWriter writer = new FileWriter(myFile,true);
			writer.append(mode);
			 writer.flush();
			 writer.close();
			 
			 if (mode.equalsIgnoreCase("1.a "))
			 {
				 count++;
			 }
			 
			
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage(),
			                    Toast.LENGTH_SHORT).show();
			        }
			
	finish();  	  
	// Intent i=new Intent(Page1.this,Page2.class);
	 Intent i=new Intent(Page1.this,Page2.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	}
 @Override
 public void onBackPressed() {
 }
}

