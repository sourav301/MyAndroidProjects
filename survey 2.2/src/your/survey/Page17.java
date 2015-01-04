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

public class Page17 extends Activity {
	
	String location;
	ImageButton submit17;
	RadioButton q17_1radio,q17_2radio,q17_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page17);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit17 = (ImageButton)findViewById(R.id.submit17);
	    q17_1radio = (RadioButton)findViewById(R.id.q17_1radio);
	    q17_2radio = (RadioButton)findViewById(R.id.q17_2radio);
	    q17_3radio = (RadioButton)findViewById(R.id.q17_3radio);
	   
	    
	    q17_1radio.setOnClickListener(answer);
	    q17_2radio.setOnClickListener(answer);
	    q17_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q17_1radio.isChecked())
		  {
			  mode="17.a ";
		  }
		  else if(q17_2radio.isChecked())
		  {
			  mode="17.b ";
		  }
		  else if(q17_3radio.isChecked())
		  {
			  mode="17.c ";
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
			 if (mode.equalsIgnoreCase("17.b "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish();	  
	 Intent i=new Intent(Page17.this,Page18.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}