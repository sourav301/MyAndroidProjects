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

public class Page15 extends Activity {
	
	String location;
	ImageButton submit15;
	RadioButton q15_1radio,q15_2radio,q15_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page15);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit15 = (ImageButton)findViewById(R.id.submit15);
	    q15_1radio = (RadioButton)findViewById(R.id.q15_1radio);
	    q15_2radio = (RadioButton)findViewById(R.id.q15_2radio);
	    q15_3radio = (RadioButton)findViewById(R.id.q15_3radio);
	   
	    
	    q15_1radio.setOnClickListener(answer);
	    q15_2radio.setOnClickListener(answer);
	    q15_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q15_1radio.isChecked())
		  {
			  mode="15.a ";
		  }
		  else if(q15_2radio.isChecked())
		  {
			  mode="15.b ";
		  }
		  else if(q15_3radio.isChecked())
		  {
			  mode="15.c ";
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
			 if (mode.equalsIgnoreCase("15.a "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish();	  
	 Intent i=new Intent(Page15.this,Page16.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}