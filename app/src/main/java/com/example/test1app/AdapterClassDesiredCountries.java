package com.example.test1app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClassDesiredCountries extends RecyclerView.Adapter<AdapterClassDesiredCountries.ViewHolderDesiredCountry> {

    private List<CountryClass> obj;
    AdapterClassDesiredCountries(){}
    public AdapterClassDesiredCountries(List<CountryClass> obj1)
    {
        obj=obj1;
    }

    @NonNull
    @Override
    public ViewHolderDesiredCountry onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.countrydetails,parent,false);
        return new AdapterClassDesiredCountries.ViewHolderDesiredCountry(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDesiredCountry holder, int position) {
        holder.tvCountry.setText(obj.get(position).getCountryName());
        holder.tvLang.setText(obj.get(position).getLanguageName());
    }

    @Override
    public int getItemCount() {
        return obj.size();
    }



    public class ViewHolderDesiredCountry extends RecyclerView.ViewHolder{
        TextView tvCountry;

        TextView tvLang;
        public ViewHolderDesiredCountry(@NonNull View itemView) {
            super(itemView);
            tvCountry=(TextView)itemView.findViewById(R.id.countcode);
            tvLang=(TextView)itemView.findViewById(R.id.countlang);
        }
    }
}
