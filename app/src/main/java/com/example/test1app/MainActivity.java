package com.example.test1app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    List<CountryClass> c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Country App");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Locale l[]=Locale.getAvailableLocales();
        c=new ArrayList<>();

        for(Locale temp:l)
        {
            if(!temp.getDisplayCountry().equals("")) {
                c.add(new CountryClass(temp.getDisplayCountry(), temp.getDisplayLanguage()));
            }
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLay,new ListCountry(c,pass))
                .commit();

    }

    PassDesiredList pass=new PassDesiredList() {
        @Override
        public void passDesiredCountryList(List<CountryClass> c) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame2Lay,new FragmentDesiredCountry(c))
                    .commit();
        }
    };
    
    public interface PassDesiredList
    {
        public void passDesiredCountryList(List<CountryClass> c);
    }

}

