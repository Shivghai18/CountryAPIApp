package com.example.test1app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListCountry extends Fragment implements AdapterClass.OnCOuntryClick{
    MainActivity.PassDesiredList passedListener;
    public static final int MAX_COUNTRIES=5;
    List<CountryClass> chosenCountry=new ArrayList<>();
    List<CountryClass> lst;

    public ListCountry(List<CountryClass> c) {
        lst=c;
    }
    public ListCountry() {

    }

    public ListCountry(List<CountryClass> c, MainActivity.PassDesiredList p)
    {
        lst=c;
        this.passedListener=p;
    }

    RecyclerView r;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_list_country, container, false);
        r=(RecyclerView)v.findViewById(R.id.re);

        AdapterClass adp=new AdapterClass(lst,this);
        r.setAdapter(adp);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        r.setLayoutManager(layoutManager);
        return v;
    }

    @Override
    public void onCountryClicked(int position) {
        CountryClass c=new CountryClass(lst.get(position).getCountryName(),lst.get(position).getLanguageName());
        int flag=0;
        if(chosenCountry.size()<MAX_COUNTRIES)
        {
            if(!chosenCountry.isEmpty())
            {
                for (CountryClass temp : chosenCountry)
                {
                    if(temp.getCountryName().equals(c.getCountryName()))
                    {
                        Toast toast = Toast. makeText(getActivity(), "Country Already Exists in your desired country list.", Toast. LENGTH_SHORT);
                        toast.show();
                        flag=1;
                    }
                }
                if(flag==0)
                {
                    chosenCountry.add(c);
                    passedListener.passDesiredCountryList(chosenCountry);
                }
            }
            else
            {
                chosenCountry.add(c);
                passedListener.passDesiredCountryList(chosenCountry);
            }
        }
        else {
            for (CountryClass temp : chosenCountry)
            {
                if(temp.getCountryName().equals(c.getCountryName()))
                {
                    Toast toast = Toast. makeText(getActivity(), "Country Already Exists in your desired country list.", Toast. LENGTH_SHORT);
                    toast.show();
                    flag=1;
                }
            }
            if(flag==0)
            {
                chosenCountry.remove(chosenCountry.size() - 1);
                chosenCountry.add(c);
                passedListener.passDesiredCountryList(chosenCountry);
            }
        }

    }

}
