package com.pet.rubymobile.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrawerItemAdapater extends RecyclerView.Adapter<DrawerItemAdapater.HomeProfile> {

   Context context;

   List itemName;
    public DrawerItemAdapater(Context context,List itemName){
        this.context=context;
        this.itemName=itemName;

    }
    @NonNull
    @Override
    public HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_drawer_item,parent,false);
        HomeProfile homeProfile=new HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProfile holder, int position) {
    holder.tvItemName.setText(itemName.get(position).toString());





    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
     AppCompatTextView tvItemName;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            tvItemName=itemView.findViewById(R.id.tvItemName);


        }
    }



}
