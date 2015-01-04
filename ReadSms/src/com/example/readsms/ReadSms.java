package com.example.readsms;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ReadSms extends Activity {

	
	
	TextView viewsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_sms);
        viewsms = (TextView)findViewById(R.id.tv);
        StringBuilder smsBuilder = new StringBuilder();
        final String SMS_URI_INBOX = "content://sms/inbox"; 
         final String SMS_URI_ALL = "content://sms/";  
         try {  
             Uri uri = Uri.parse(SMS_URI_INBOX);  
             String[] projection = new String[] {  "address", "person", "body", "date", "type" };  
             Cursor cur = getContentResolver().query(uri, projection, null, null, "date desc");
              if (cur.moveToFirst()) {  
                 int index_Address = cur.getColumnIndex("address");  
                 int index_Person = cur.getColumnIndex("person");  
                 int index_Body = cur.getColumnIndex("body");  
                 int index_Date = cur.getColumnIndex("date");  
                 int index_Type = cur.getColumnIndex("type");         
                 do {  
                     String strAddress = cur.getString(index_Address);  
                     int intPerson = cur.getInt(index_Person);  
                     String strbody = cur.getString(index_Body);  
                     long longDate = cur.getLong(index_Date);  
                     int int_Type = cur.getInt(index_Type);  

                     smsBuilder.append("[ ");  
                     smsBuilder.append(strAddress + "-------- \n ");  
                      smsBuilder.append(strbody + ", ");  
                     //smsBuilder.append(longDate + ", ");  
                      smsBuilder.append(" ]\n\n");
                      if(smsBuilder.toString().contains("IP")&&smsBuilder.toString().contains("Command"))
                      {
                    	Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(intent, 0);                      
                      }
                 } while (cur.moveToNext());  

                 if (!cur.isClosed()) {  
                     cur.close();  
                     cur = null;  
                 }  
             } else {  
                 smsBuilder.append("no result!!!!");  
             } // end if  
           } catch (SQLiteException ex) {  
             Log.d("SQLiteException", ex.getMessage());  
         }  
        viewsms.setText(smsBuilder.toString());
//        if(smsBuilder.toString().contains("Life is too ironic"))
//        {	Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        startActivityForResult(intent, 0); 
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.read_sms, menu);
        return true;
    }
    
}
