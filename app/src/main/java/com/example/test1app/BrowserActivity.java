package com.example.test1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;



public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        setTitle("Web Activity");
        Intent i=getIntent();
        Uri uri=i.getData();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayHum,new BrowserFragment(uri.toString()))
                .commit();
    }
}
