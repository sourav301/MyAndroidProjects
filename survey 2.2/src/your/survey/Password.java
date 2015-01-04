package your.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends Activity{

	
	Button button1;
	EditText editText1;
	String password="password";
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.password);
		
		
		editText1=(EditText)findViewById(R.id.editText1);
		button1=(Button)findViewById(R.id.button1);
		
	}
		
	public void send (View v)
	    {
			
			String pass=editText1.getText().toString();
			if(pass.equalsIgnoreCase(password))
			{
				finish();
				startActivity(new Intent(this,View_details.class));
				 Toast.makeText(getBaseContext(),"Correct Password  ",
		                    Toast.LENGTH_SHORT).show();
			}
			else if(!pass.equalsIgnoreCase(password))
			{
				 Toast.makeText(getBaseContext(), "Wrong Password  ",
		                    Toast.LENGTH_SHORT).show();
			}
	
	    }
	
}
