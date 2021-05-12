package com.example.smallapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    List<UserListResponce.DataBean> mList;
    Context context;
    int resource;

    public ListAdapter(@NonNull Context context, int resource,List<UserListResponce.DataBean> mList) {
        this.mList=mList;
        this.context=context;
        this.resource=resource;
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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.custm_list,null,true);
        }

        UserListResponce.DataBean userListResponce = mList.get(position);

        /*TextView textViewfrst=(TextView)convertView.findViewById(R.id.Tv_frstname);
        TextView textViewlast=(TextView)convertView.findViewById(R.id.Tv_LastName);
        TextView textViewemail=(TextView)convertView.findViewById(R.id.Tv_email);*/

       /* textViewfrst.setText(userListResponce.getFirst_name());
        textViewlast.setText(userListResponce.getLast_name());
        textViewemail.setText(userListResponce.getEmail());*/
        return convertView;

    }

}
