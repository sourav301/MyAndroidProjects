package your.survey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Set_details_2 extends Activity {
	EditText editText4,editText5,editText6,editText7,editText8;
	String location;
	ImageButton button1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_details_2);
        
        Intent i=getIntent();
		location=i.getStringExtra("location");
        button1=(ImageButton)findViewById(R.id.button1);
        editText5=(EditText)findViewById(R.id.editText5);
        editText6=(EditText)findViewById(R.id.editText6);
        editText7=(EditText)findViewById(R.id.editText7);
        editText8=(EditText)findViewById(R.id.editText8);
        
      
        InputFilter[] FilterArray1=new InputFilter[2];
        FilterArray1[0]=new InputFilter.LengthFilter(2);
        FilterArray1[1]=new InputFilter(){

			public CharSequence filter(CharSequence src, int arg1, int arg2,
					Spanned arg3, int arg4, int arg5) {
				if(src.toString().matches("[0-9]"))
				{
					return src;
				}
				return "";
			}};
        editText5.setFilters(FilterArray1);
        
        InputFilter[] FilterArray2=new InputFilter[2];
        FilterArray2[0]=new InputFilter.LengthFilter(2);
        FilterArray2[1]=new InputFilter(){

			public CharSequence filter(CharSequence src, int arg1, int arg2,
					Spanned arg3, int arg4, int arg5) {
				if(src.toString().matches("[0-9]"))
				{
					return src;
				}
				return "";
			}};
        editText6.setFilters(FilterArray2);
        
        InputFilter[] FilterArray3=new InputFilter[2];
        FilterArray3[0]=new InputFilter.LengthFilter(3);
        FilterArray3[1]=new InputFilter(){

			public CharSequence filter(CharSequence src, int arg1, int arg2,
					Spanned arg3, int arg4, int arg5) {
				if(src.toString().matches("[0-9]"))
				{
					return src;
				}
				return "";
			}};
        editText7.setFilters(FilterArray3);
        
        InputFilter[] FilterArray4=new InputFilter[2];
        FilterArray4[0]=new InputFilter.LengthFilter(6);
        FilterArray4[1]=new InputFilter(){

			public CharSequence filter(CharSequence src, int arg1, int arg2,
					Spanned arg3, int arg4, int arg5) {
				if(src.toString().matches("[0-9]"))
				{
					return src;
				}
				if(src.toString().matches("."))
				{
					return src;
				}
				return "";
			}};
        editText8.setFilters(FilterArray4);
                
}
	public void send(View v)
	{
		if(v.getId()==R.id.button1)
		{
			
			String et5=editText5.getText().toString();
			String et6=editText6.getText().toString();
			String et7=editText7.getText().toString();
			String et8=editText8.getText().toString();
			
			
			if (et7.length()==0)
			{
				et7="0";
			}
			if(et8.length()==0)
			{
				et8="0";
			}
	          if(et5.length()==0 || et6.length()==0)
				{
	        	  Toast.makeText(getBaseContext(),"ENTER ALL DETAILS",Toast.LENGTH_SHORT).show(); 
				}
	          else if(Integer.parseInt(et5)>25 )
				{
	        	  Toast.makeText(getBaseContext(),"Age Should Be Less than 25 Years",Toast.LENGTH_SHORT).show(); 
				}
	          else if( Integer.parseInt(et6)>12 )
				{
	        	  Toast.makeText(getBaseContext(),"Class Should Be Less than 12",Toast.LENGTH_SHORT).show(); 
				}
	          else if(Integer.parseInt(et7)>150)
				{
	        	  Toast.makeText(getBaseContext(),"Weight Should Be Less than 150",Toast.LENGTH_SHORT).show(); 
				}
	          else if(Float.parseFloat(et8)>8)
				{
	        	  Toast.makeText(getBaseContext(),"Height Should Be Less than 8.0",Toast.LENGTH_SHORT).show(); 
				}
	          
	          else{
	        	  File detailFile = new File("/sdcard/SURVEY/"+location+"/details.txt");
	  			
	 	         
		          try {
		        	
		        	  if(et7.equalsIgnoreCase("0"))
		        	  {
		        		  et7="N/A";
		        	  }
		        	  
		        	  
		        	  if(et8.equalsIgnoreCase("0"))
		        	  {
		        		  et8="N/A";
		        	  }
		        	
		              FileWriter writer;
					  writer = new FileWriter(detailFile,true);
				
					  
				     writer.append("AGE      : ");
					 writer.append(et5+"\n"+"\n");
					 writer.append("CLASS    : ");
					 writer.append(et6+"\n"+"\n");
					 writer.append("WEIGHT   : ");
					 writer.append(et7+" KG"+"\n"+"\n");
					 writer.append("HEIGHT   : ");
					 writer.append(et8+" ft"+"\n"+"\n");
					 writer.flush();
					 writer.close();
					 
					       
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	  Toast.makeText(getBaseContext(),"SUBMITTED",Toast.LENGTH_SHORT).show();
	          finish();
	         Intent i=new Intent(this,CameraActivity.class);
	       //Intent i=new Intent(this,CameraActivity.class);
	          
	          i.putExtra("location",location);
		   	   startActivity(i);
	          }
		}
	}
	public void onBackPressed() {
	 }
}