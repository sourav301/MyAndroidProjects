package your.survey;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Set_details_1 extends Activity {
	EditText editText1,editText2,editText3,editText4;
	ImageButton imageButton1;
	String location;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_details_1);
       
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        imageButton1=(ImageButton)findViewById(R.id.imageButton1);
        
      
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(11);
        editText4.setFilters(FilterArray);
        
        Intent i=getIntent();
		location=i.getStringExtra("location");

}
	public void sends(View v)
	{
		
		String et2=editText2.getText().toString();
		String et3=editText3.getText().toString();
		String et4=editText4.getText().toString();
		
		if(v.getId()==R.id.imageButton1)
		{
			
			
			
			
			if(et2.length()==0 || et3.length()==0 || et4.length()==0)
			{Toast.makeText(getBaseContext(),"ENTER ALL DETAILS",Toast.LENGTH_SHORT).show(); 
				
			}
		
		 else {
			 File detailFile = new File("/sdcard/SURVEY/"+location+"/details.txt");
				
	         
	          try {
	        	  
	        	  detailFile.createNewFile();
	        	  detailFile.delete();
	        	  detailFile.createNewFile();
	              FileWriter writer;
				  writer = new FileWriter(detailFile,true);
			
				 
				
				 
				  writer.append("\n"+"ADDRESS  : ");
				  writer.append(et2+"\n"+"\n");
				  writer.append("SCHOOL   : ");
				  writer.append(et3+"\n"+"\n");
				  writer.append("Ph. No.  : ");
				  writer.append(et4+"\n"+"\n");
				 writer.flush();
				 writer.close();
				Toast.makeText(getBaseContext(),"SUBMITTED",Toast.LENGTH_SHORT).show();
				       
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			 finish();
         Intent i=new Intent(this,Set_details_2.class);
 	     i.putExtra("location",location);
 	     startActivity(i);
			
		   }
		}
	}
	public void onBackPressed() {
	 }
}