package your.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Exit extends Activity{

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.exit);
	
}
	 public void send(View v)  
		{
		finish();
		 Intent intent = new Intent(Exit.this,Startpage.class);
 		
		}
}
