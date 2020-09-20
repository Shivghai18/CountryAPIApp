package com.example.test1app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolderCountry> {

private List<CountryClass> obj;
OnCOuntryClick countryClick;
    public AdapterClass(List<CountryClass> obj1,OnCOuntryClick countryClick)
    {
        this.obj=obj1;
        this.countryClick=countryClick;
    }

    @NonNull
    @Override
    public ViewHolderCountry onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.countrydetails,parent,false);
        return new ViewHolderCountry(v,countryClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCountry holder, int position) {
        holder.tvCountry.setText(obj.get(position).getCountryName());
        holder.tvLang.setText(obj.get(position).getLanguageName());
    }

    @Override
    public int getItemCount() {
        return obj.size();
    }


    public class ViewHolderCountry extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tvCountry;

        OnCOuntryClick click;
        TextView tvLang;
        public ViewHolderCountry(@NonNull View itemView,OnCOuntryClick click) {
            super(itemView);
            tvCountry=(TextView)itemView.findViewById(R.id.countcode);
            tvLang=(TextView)itemView.findViewById(R.id.countlang);
            this.click=click;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            click.onCountryClicked(getAbsoluteAdapterPosition());
        }
    }

    public interface OnCOuntryClick{
        void onCountryClicked(int position);
    }
}
