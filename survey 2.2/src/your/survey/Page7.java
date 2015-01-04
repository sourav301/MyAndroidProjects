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

public class Page7 extends Activity {
	
	String location;
	ImageButton submit7;
	RadioButton q7_1radio,q7_2radio,q7_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page7);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit7 = (ImageButton)findViewById(R.id.submit7);
	    q7_1radio = (RadioButton)findViewById(R.id.q7_1radio);
	    q7_2radio = (RadioButton)findViewById(R.id.q7_2radio);
	    q7_3radio = (RadioButton)findViewById(R.id.q7_3radio);
	   
	    
	    q7_1radio.setOnClickListener(answer);
	    q7_2radio.setOnClickListener(answer);
	    q7_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q7_1radio.isChecked())
		  {
			  mode="7.a ";
		  }
		  else if(q7_2radio.isChecked())
		  {
			  mode="7.b ";
		  }
		  else if(q7_3radio.isChecked())
		  {
			  mode="7.c ";
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
			 if (mode.equalsIgnoreCase("7.c "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish(); 	  
	 Intent i=new Intent(Page7.this,Page8.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}