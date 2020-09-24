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

public class DrawerAdapater extends RecyclerView.Adapter<DrawerAdapater.HomeProfile> {

   Context context;
   boolean flagOne=false;
    DrawerItemAdapater drawerItemAdapater;

    public DrawerAdapater(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public DrawerAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_drawer,parent,false);
        DrawerAdapater.HomeProfile homeProfile=new DrawerAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerAdapater.HomeProfile holder, int position) {
        drawerItemAdapater = new DrawerItemAdapater(context);
        holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.rvMenuItem.setAdapter(drawerItemAdapater);


        holder.rvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagOne){
                    holder.rvMenuItem.setVisibility(View.VISIBLE);
                    flagOne=true;
                }else{
                    holder.rvMenuItem.setVisibility(View.VISIBLE);
                    flagOne=false;
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return 8;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        RecyclerView rvMenuItem;
        RelativeLayout rvTitle;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvMenuItem=itemView.findViewById(R.id.rvMenuItem);
            rvTitle=itemView.findViewById(R.id.rvTitle);


        }
    }



}
