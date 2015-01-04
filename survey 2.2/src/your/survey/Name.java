package your.survey;

import java.io.File;
import java.io.FileWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Name extends Activity{
	
	TextView textView1;
	EditText editText1;
	ImageButton button1;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name);
		editText1=(EditText)findViewById(R.id.editText1);
		button1=(ImageButton)findViewById(R.id.button1);
		
		String newFolder = "/SURVEY/";
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File myNewFolder = new File(extStorageDirectory + newFolder);
        myNewFolder.mkdir();

	}
		
		public void send(View v)  
		{
			
			String str;
			str=editText1.getText().toString();
			if(str.length()<2)
			{
				Toast.makeText(getBaseContext(),"Enter Name",Toast.LENGTH_SHORT).show();
			}
			else
			{
			String location = str.replace(" ", "_");
			Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
			  	String newFolder = "/SURVEY/"+location;
		        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
		        File myNewFolder = new File(extStorageDirectory + newFolder);
		        myNewFolder.mkdir();
		          try {
		          File myFile = new File("/sdcard/SURVEY/"+location+"/answers.txt");
		          File detailFile = new File("/sdcard/SURVEY/"+location+"/details.txt");
		          File nameFile = new File("/sdcard/SURVEY/"+"/names.txt");
		          
		          myFile.createNewFile();
		          nameFile.createNewFile();
		          detailFile.createNewFile();
		       
		          myFile.delete();
		          detailFile.delete();
		         
		          myFile.createNewFile();
		          nameFile.createNewFile();
		          detailFile.createNewFile();
		          
		          
		          FileWriter writer = new FileWriter(nameFile,true);
					writer.append("NAME:"+str+"\n");
					 writer.flush();
					 writer.close();
					Toast.makeText(getBaseContext(),"Files Created",Toast.LENGTH_SHORT).show();
					       
		          
		          
		            
		        } catch (Exception e) {
		            Toast.makeText(getBaseContext(), e.getMessage(),
		                    Toast.LENGTH_LONG).show();
		        }
		
			
		          finish();
			Intent i=new Intent(Name.this,Set_details_1.class);
			i.putExtra("location",location);
			startActivity(i);
			}
		}
		
		
}
