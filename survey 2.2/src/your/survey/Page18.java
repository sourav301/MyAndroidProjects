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

public class Page18 extends Activity {
	
	String location;
	ImageButton submit18;
	RadioButton q18_1radio,q18_2radio,q18_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page18);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit18 = (ImageButton)findViewById(R.id.submit18);
	    q18_1radio = (RadioButton)findViewById(R.id.q18_1radio);
	    q18_2radio = (RadioButton)findViewById(R.id.q18_2radio);
	    q18_3radio = (RadioButton)findViewById(R.id.q18_3radio);
	   
	    
	    q18_1radio.setOnClickListener(answer);
	    q18_2radio.setOnClickListener(answer);
	    q18_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q18_1radio.isChecked())
		  {
			  mode="18.a ";
		  }
		  else if(q18_2radio.isChecked())
		  {
			  mode="18.b ";
		  }
		  else if(q18_3radio.isChecked())
		  {
			  mode="18.c ";
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
		 if (mode.equalsIgnoreCase("18.a "))
		 {
			 count++;
		 }	
		 File myFile = new File("/sdcard/SURVEY/"+location+"/answers.txt");
		 	FileWriter writer = new FileWriter(myFile,true);
			writer.append(mode);
			writer.append("\n"+"\n"+"Marks = "+count+" out of 16.");
			 writer.flush();
			 writer.close();
			 
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish(); 
	 Intent i=new Intent(Page18.this,Exit.class);
	 i.putExtra("location",location);
	   
	   startActivity(i);
	    	}	
	    	
	    }
 @Override
 public void onBackPressed() {
	 
 }
}
