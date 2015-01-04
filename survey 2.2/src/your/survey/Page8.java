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

public class Page8 extends Activity {
	
	String location;
	ImageButton submit8;
	RadioButton q8_1radio,q8_2radio,q8_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page8);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit8 = (ImageButton)findViewById(R.id.submit8);
	    q8_1radio = (RadioButton)findViewById(R.id.q8_1radio);
	    q8_2radio = (RadioButton)findViewById(R.id.q8_2radio);
	    q8_3radio = (RadioButton)findViewById(R.id.q8_3radio);
	   
	    
	    q8_1radio.setOnClickListener(answer);
	    q8_2radio.setOnClickListener(answer);
	    q8_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q8_1radio.isChecked())
		  {
			  mode="8.a ";
		  }
		  else if(q8_2radio.isChecked())
		  {
			  mode="8.b ";
		  }
		  else if(q8_3radio.isChecked())
		  {
			  mode="8.c ";
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
			 if (mode.equalsIgnoreCase("8.b "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish(); 
	 Intent i=new Intent(Page8.this,Part2.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}