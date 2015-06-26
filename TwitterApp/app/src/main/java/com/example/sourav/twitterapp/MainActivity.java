package com.example.sourav.twitterapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sourav.twitterapp.api.gitapi;
import com.example.sourav.twitterapp.model.gitmodel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    TextView helloTextView;
    Button myButton;
    String API = "https://api.github.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloTextView=(TextView)findViewById(R.id.helloWorld);
        myButton = (Button)findViewById(R.id.myButton);
    }
    public void click(View v){
//        Toast.makeText(this,"Button Clicked",Toast.LENGTH_LONG).show();
//        CallAsync async = new CallAsync(MainActivity.this);
//        async.execute();

//        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API).build();
//        gitapi git = restAdapter.create(gitapi.class);
//        git.getFeed("sourav301",new Callback<gitmodel>() {
//
//            @Override
//            public void success(gitmodel gitmodel, Response response) {
//                helloTextView.setText("Github Name :"+gitmodel.getName()+"\nWebsite :"+gitmodel.getBlog()+"\nCompany Name :"+gitmodel.getCompany());
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                helloTextView.setText(error.getMessage());
//            }
//        });

        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(API).build();
        gitapi git = restAdapter.create(gitapi.class);
        git.getFeed("sourav301",new Callback<gitmodel>() {

            @Override
            public void success(gitmodel gitmodel, Response response) {
                helloTextView.setText("Github Name :"+gitmodel.getName()+"\nWebsite :"+gitmodel.getBlog()+"\nCompany Name :"+gitmodel.getCompany());
            }

            @Override
            public void failure(RetrofitError error) {
                helloTextView.setText(error.getMessage());
            }
        });

    }



}
