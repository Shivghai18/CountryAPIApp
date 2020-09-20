package com.example.test1app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDesiredCountry extends Fragment {
    List<CountryClass> lst;
    public FragmentDesiredCountry(List<CountryClass> lst) {
        this.lst=lst;
    }

    RecyclerView r;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_desired_country, container, false);

        r=(RecyclerView)v.findViewById(R.id.re2);

        AdapterClassDesiredCountries adp=new AdapterClassDesiredCountries(lst);
        r.setAdapter(adp);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        r.setLayoutManager(layoutManager);
        return v;
    }

}
