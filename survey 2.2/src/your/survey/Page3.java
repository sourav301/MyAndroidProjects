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

public class Page3 extends Activity {
	
	String location;
	ImageButton submit3;
	RadioButton q3_1radio,q3_2radio,q3_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page3);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit3 = (ImageButton)findViewById(R.id.submit3);
	    q3_1radio = (RadioButton)findViewById(R.id.q3_1radio);
	    q3_2radio = (RadioButton)findViewById(R.id.q3_2radio);
	    q3_3radio = (RadioButton)findViewById(R.id.q3_3radio);
	   
	    
	    q3_1radio.setOnClickListener(answer);
	    q3_2radio.setOnClickListener(answer);
	    q3_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q3_1radio.isChecked())
		  {
			  mode="3.a ";
		  }
		  else if(q3_2radio.isChecked())
		  {
			  mode="3.b ";
		  }
		  else if(q3_3radio.isChecked())
		  {
			  mode="3.c ";
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
			 if (mode.equalsIgnoreCase("3.c "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish();  
	 Intent i=new Intent(Page3.this,Page4.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}
