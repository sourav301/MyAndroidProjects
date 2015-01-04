package your.survey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class View_details  extends ListActivity{

	String[] namesarray=new String[100000];
	String name,location;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
				File sdcard = Environment.getExternalStorageDirectory();

				//Get the text file
				File file = new File(sdcard,"/SURVEY/names.txt");
				StringBuilder text = new StringBuilder();
				
				try {
				    BufferedReader br = new BufferedReader(new FileReader(file));
				    String line;

				    while ((line = br.readLine()) != null) {
				       text.append(line);
				    	name=text.toString();
				    	
				    	//int i=0;
				    	namesarray=name.split("NAME:");
				       // i=i+i;
				    	
				       
				        
				
				
		
		
		setListAdapter(new ArrayAdapter<String>(this,R.layout.view_details,namesarray)); 
		
		ListView list=getListView();
		list.setTextFilterEnabled(true);
		list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), ((TextView) arg1).getText(), Toast.LENGTH_SHORT).show();
				location=(String) ((TextView) arg1).getText();
				Intent i=new Intent(View_details.this,View_details_1.class);
				   i.putExtra("location",location.replace(" ", "_"));
				   startActivity(i);
			
			}
			 
		});
        
				    }
				}
				catch (IOException e) {
					Toast.makeText(getBaseContext(), "EMPTY",Toast.LENGTH_SHORT).show();
				}
				
			
		
	}
	

}


