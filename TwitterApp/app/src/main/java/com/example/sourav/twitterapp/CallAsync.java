package com.example.sourav.twitterapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by Sourav on 6/26/2015.
 */
public class CallAsync extends AsyncTask {
    Context context;
    TextView myTv;
    public CallAsync(Context context){
        this.context=context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myTv=((MainActivity)context).helloTextView;
        myTv.setText("Fetching Data From Async task");

    }

    @Override
    protected Object doInBackground(Object[] params){





//        try {
//            Thread.sleep(5000);
//        }catch(Exception e){}
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        myTv=((MainActivity)context).helloTextView;
        myTv.setText("Data From Async task");
    }
}
