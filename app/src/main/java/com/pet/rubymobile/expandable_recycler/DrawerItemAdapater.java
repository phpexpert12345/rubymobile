package com.pet.rubymobile.expandable_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrawerItemAdapater extends RecyclerView.Adapter<DrawerItemAdapater.HomeProfile> {

   Context context;


    public DrawerItemAdapater(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public DrawerItemAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_drawer_item,parent,false);
        DrawerItemAdapater.HomeProfile homeProfile=new DrawerItemAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerItemAdapater.HomeProfile holder, int position) {






    }

    @Override
    public int getItemCount() {
        return 8;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{


        public HomeProfile(@NonNull View itemView) {
            super(itemView);



        }
    }



}
