package com.example.smallapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterForList extends BaseAdapter {

    List<ModelClssGetid.ResponseBean> mList;
    Context context;
    int resource;

    public AdapterForList(List<ModelClssGetid.ResponseBean> mList, Context context, int resource) {
        this.mList = mList;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.custm_list,null,true);
        }

        ModelClssGetid.ResponseBean mData =mList.get(i);

        TextView textViewid=(TextView)view.findViewById(R.id.Tv_id);
        TextView textViewtitle=(TextView)view.findViewById(R.id.Tv_title);
        TextView textViewtype=(TextView)view.findViewById(R.id.Tv_type);

        textViewid.setText(mData.getApplication_id());
        textViewtitle.setText(mData.getTitle());
        textViewtype.setText(mData.getType());


        return view;
    }
}
