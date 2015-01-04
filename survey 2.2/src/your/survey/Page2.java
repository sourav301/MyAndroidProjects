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

public class Page2 extends Activity {
	
	String location;
	ImageButton submit2;
	RadioButton q2_1radio,q2_2radio,q2_3radio;
	String mode="";
	int count=0;
	    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page2);
		Intent i=getIntent();
		location=i.getStringExtra("location");
		count=i.getIntExtra("count",-1);
		
	    submit2 = (ImageButton)findViewById(R.id.submit2);
	    q2_1radio = (RadioButton)findViewById(R.id.q2_1radio);
	    q2_2radio = (RadioButton)findViewById(R.id.q2_2radio);
	    q2_3radio = (RadioButton)findViewById(R.id.q2_3radio);
	   
	    
	    q2_1radio.setOnClickListener(answer);
	    q2_2radio.setOnClickListener(answer);
	    q2_3radio.setOnClickListener(answer);
	   
	    
	    
  }

  RadioButton.OnClickListener answer=new RadioButton.OnClickListener()
 {
	   public void onClick(View view)
	   {
		  if(q2_1radio.isChecked())
		  {
			  mode="2.a ";
		  }
		  else if(q2_2radio.isChecked())
		  {
			  mode="2.b ";
		  }
		  else if(q2_3radio.isChecked())
		  {
			  mode="2.c ";
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
			 if (mode.equalsIgnoreCase("2.a "))
			 {
				 count++;
			 }
			 
			Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
			        } catch (Exception e) {
			            Toast.makeText(getBaseContext(), e.getMessage()+location,
			                    Toast.LENGTH_SHORT).show();
			        }
			
	 finish();  
	 Intent i=new Intent(Page2.this,Page3.class);
	   i.putExtra("location",location);
	   i.putExtra("count",count);
	   startActivity(i);
	    	}	
	}
 @Override
 public void onBackPressed() {
	 
 }
}
