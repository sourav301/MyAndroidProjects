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

public class Page12 extends Activity {
	
	String location;
	ImageButton submit12;
	RadioButton q12_1radio,q12_2radio,q12_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page12);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit12 = (ImageButton)findViewById(R.id.submit12);
	    q12_1radio = (RadioButton)findViewById(R.id.q12_1radio);
	    q12_2radio = (RadioButton)findViewById(R.id.q12_2radio);
	    q12_3radio = (RadioButton)findViewById(R.id.q12_3radio);
	   
	    
	    q12_1radio.setOnClickListener(answer);
	    q12_2radio.setOnClickListener(answer);
	    q12_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q12_1radio.isChecked())
		  {
			  mode="12.a ";
		  }
		  else if(q12_2radio.isChecked())
		  {
			  mode="12.b ";
		  }
		  else if(q12_3radio.isChecked())
		  {
			  mode="12.c ";
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
			 if (mode.equalsIgnoreCase("12.a "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish();  
	 Intent i=new Intent(Page12.this,Page13.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	    	
	    }@Override
	    public void onBackPressed() {
	   	 
	    }
	    
}
