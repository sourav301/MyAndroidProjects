package your.survey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class View_details_1 extends Activity{
	
	TextView textView1;
	TextView textView2;
	String location;
	ImageView imageView1;
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.view_details_1);
			
			imageView1=(ImageView)findViewById(R.id.imageView1);
			textView1=(TextView)findViewById(R.id.textView1);
			textView2=(TextView)findViewById(R.id.textView2);
			
			Intent i=getIntent();
			location=i.getStringExtra("location");
			
			 Toast.makeText(getBaseContext(), "DETAILS \n"+"|"+location+"|",
	                    Toast.LENGTH_LONG).show();
			File sdcard = Environment.getExternalStorageDirectory();
			
			File imgFile = new File(sdcard,"/SURVEY/"+location+"/picture.jpg");
			if(imgFile.exists()){

			    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

			    imageView1.setImageBitmap(myBitmap);

			}
			
			
					
			File file = new File(sdcard,"/SURVEY/"+location+"/details.txt");
			
			StringBuilder text = new StringBuilder();
			
			try {
			    BufferedReader br = new BufferedReader(new FileReader(file));
			    String line;
			    text.append("NAME    :"+location.replace("_"," ")+"\n");
			    while ((line = br.readLine()) != null) {
			    	
			    	text.append(line);
			       text.append("\n");
			    	
			      textView1.setText(text);
			    }
			}
			catch (IOException e) {
				Toast.makeText(getBaseContext(), "FAILED TO GET DATA" ,Toast.LENGTH_SHORT).show();
			}
          File file1 = new File(sdcard,"/SURVEY/"+location+"/answers.txt");
			
			StringBuilder text1 = new StringBuilder();
			
			
			try {
			    BufferedReader br = new BufferedReader(new FileReader(file1));
			    String line1;
			    text1.append("ANSWERS:-"+"\n");
			    while ((line1 = br.readLine()) != null) {
			    	
			    	text1.append(line1);
			       text1.append("\n");
			    	
			      textView2.setText(text1);
			    }
			}
			catch (IOException e) {
				Toast.makeText(getBaseContext(), "FAILED TO GET DATA" ,Toast.LENGTH_SHORT).show();
			}
			
			
			
			
			
}

}