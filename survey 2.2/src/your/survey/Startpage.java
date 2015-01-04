package your.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Startpage extends Activity {
    /** Called when the activity is first created. */
	ImageButton button1,button2,button3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);
        
        button1=(ImageButton) findViewById(R.id.button1);
        button2=(ImageButton) findViewById(R.id.button2);
        button3=(ImageButton) findViewById(R.id.button3);
    }
    public void send (View v)
    {
    	
    	
    	if(v.getId()==R.id.button1)
    	{
    		
    		startActivity(new Intent(this,Password.class));
    	}
    	else if(v.getId()==R.id.button2)
    	{
    		finish();
    		Intent intent = new Intent(Intent.ACTION_MAIN);
    		intent.addCategory(Intent.CATEGORY_HOME);
    		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    		startActivity(intent);

    	}
    	else if(v.getId()==R.id.button3)
    	{
    		startActivity(new Intent(this,Agreement.class));
    	}
    	
    }
}