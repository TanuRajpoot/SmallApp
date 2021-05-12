package com.example.smallapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecycle  extends RecyclerView.Adapter<AdapterRecycle.Myclass> {

    List<Model> mList;
    Context context;

    public AdapterRecycle(List<Model> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public Myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custm_recyclerdata,parent,false);
        return new Myclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myclass holder, int position) {

        Model model=mList.get(position);
        holder.Tv_year.setText(model.getYear());
        holder.Tv_pricple.setText(model.getPrincple());
        holder.Tv_interst.setText(model.getInterest());
        holder.Tv_total.setText(model.getTotal());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class Myclass extends RecyclerView.ViewHolder {

        TextView Tv_year,Tv_pricple,Tv_interst,Tv_total;

        public Myclass(@NonNull View itemView) {
            super(itemView);

            Tv_year=itemView.findViewById(R.id.Tv_year);
            Tv_pricple=itemView.findViewById(R.id.Tv_pricple);
            Tv_interst=itemView.findViewById(R.id.Tv_interst);
            Tv_total=itemView.findViewById(R.id.Tv_total);
        }
    }
}
