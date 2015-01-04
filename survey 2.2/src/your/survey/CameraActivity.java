package your.survey;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends Activity {
    /** Called when the activity is first created. */
	
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
     private Uri fileUri;
     String location;
     ImageButton button1;
     ImageView imageView1;
     
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.camera);
           
            imageView1=(ImageView)findViewById(R.id.imageView1);
            Intent i=getIntent();
    		location=i.getStringExtra("location");
    		button1=(ImageButton)findViewById(R.id.button1);
    		Toast.makeText(getBaseContext(),location,Toast.LENGTH_SHORT).show();
		
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            location = location.replace(" ", "_");
			String newFolder = "/SURVEY/"+location;
		       
            
            
            File image = new File("/sdcard/SURVEY/"+location+"/picture.jpg");
            Uri uriSavedImage = Uri.fromFile(image);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage); 

          
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            	
            File sdcard = Environment.getExternalStorageDirectory();
			File imgFile = new File(sdcard,"/SURVEY/"+location+"/picture.jpg");
			if(imgFile.exists()){
				Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
				imageView1.setImageBitmap(myBitmap);
    			    }
            
        }
        
        public void send(View v)
        {
        	
        	File image = new File("/sdcard/SURVEY/"+location+"/picture.jpg");
        	if(image.exists())
        	{
        	finish();  
        	Intent i=new Intent(this,Part1.class);
		   	 i.putExtra("location",location);
		   	 startActivity(i);
		   	Toast.makeText(getBaseContext(),"PICTURE SAVED",Toast.LENGTH_SHORT).show(); 
             }
        	else
        	{
        		
        		Intent j=new Intent(this,CameraActivity.class);
        	}
        }
        
        
        public void retake(View v)
        {
        	//Intent j=new Intent(this,CameraActivity.class);
        	//startActivity(j);
        	 try
             {
             Intent i=getIntent();
     		location=i.getStringExtra("location");
     		
     		button1=(ImageButton)findViewById(R.id.button1);
     		
     		Toast.makeText(getBaseContext(),location,Toast.LENGTH_SHORT).show();
 		
             
             Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
  
             location = location.replace(" ", "_");
 			  	String newFolder = "/SURVEY/"+location;
 		       
             
             
             File image = new File("/sdcard/SURVEY/"+location+"/picture.jpg");
             Uri uriSavedImage = Uri.fromFile(image);
           
             intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage); 

           
             startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
         	location=i.getStringExtra("location");
			
			 Toast.makeText(getBaseContext(), "DETAILS \n"+"|"+location+"|",
	                    Toast.LENGTH_LONG).show();
			File sdcard = Environment.getExternalStorageDirectory();
			
			File imgFile = new File(sdcard,"/SURVEY/"+location+"/picture.jpg");
			if(imgFile.exists()){

			    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

			    imageView1.setImageBitmap(myBitmap);
			}
            
             
             }
             catch(Exception e){
            
             	
             }
        	
        }
        
        public void refresh(View v)
        {
        	
        	 try
             {
            
             
			File sdcard = Environment.getExternalStorageDirectory();
			
			File imgFile = new File(sdcard,"/SURVEY/"+location+"/picture.jpg");
			if(imgFile.exists()){

			    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

			    imageView1.setImageBitmap(myBitmap);
			}
            
             
             }
             catch(Exception e){
            
             	
             }
        	
        }
        
        
        
        @Override
        public void onBackPressed() {
       	 
        }
  }

