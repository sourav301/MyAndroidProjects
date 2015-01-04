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

public class Page6 extends Activity {
	
	String location;
	ImageButton submit6;
	RadioButton q6_1radio,q6_2radio,q6_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page6);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit6 = (ImageButton)findViewById(R.id.submit6);
	    q6_1radio = (RadioButton)findViewById(R.id.q6_1radio);
	    q6_2radio = (RadioButton)findViewById(R.id.q6_2radio);
	    q6_3radio = (RadioButton)findViewById(R.id.q6_3radio);
	   
	    
	    q6_1radio.setOnClickListener(answer);
	    q6_2radio.setOnClickListener(answer);
	    q6_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q6_1radio.isChecked())
		  {
			  mode="6.a ";
		  }
		  else if(q6_2radio.isChecked())
		  {
			  mode="6.b ";
		  }
		  else if(q6_3radio.isChecked())
		  {
			  mode="6.c ";
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
			 if (mode.equalsIgnoreCase("6.a "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish(); 
	 Intent i=new Intent(Page6.this,Page7.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}
