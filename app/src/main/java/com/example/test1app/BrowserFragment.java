package com.example.test1app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class BrowserFragment extends Fragment {

    TextView tv;
    String urlInfo;
    public BrowserFragment() {

    }


    public BrowserFragment(String str)
    {
        urlInfo=str;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_browser, container, false);
        tv=(TextView)v.findViewById(R.id.weblink);
        tv.setText(urlInfo);
        return v;
    }
}
