package your.survey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Page13 extends Activity {
	
	String location;
	ImageButton submit13;
	RadioButton q13_1radio,q13_2radio,q13_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page13);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit13 = (ImageButton)findViewById(R.id.submit13);
	    q13_1radio = (RadioButton)findViewById(R.id.q13_1radio);
	    q13_2radio = (RadioButton)findViewById(R.id.q13_2radio);
	    q13_3radio = (RadioButton)findViewById(R.id.q13_3radio);
	   
	    
	    q13_1radio.setOnClickListener(answer);
	    q13_2radio.setOnClickListener(answer);
	    q13_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q13_1radio.isChecked())
		  {
			  mode="13.a ";
		  }
		  else if(q13_2radio.isChecked())
		  {
			  mode="13.b ";
		  }
		  else if(q13_3radio.isChecked())
		  {
			  mode="13.c ";
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
			 if (mode.equalsIgnoreCase("13.b "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish();  
	 Intent i=new Intent(Page13.this,Page14.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}
