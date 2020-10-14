package com.pet.rubymobile.drawer_ecommerce.trackOrder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.EcomCatDetailsFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrackOrderEcomAdapater extends RecyclerView.Adapter<TrackOrderEcomAdapater.HomeProfile> {

   Context context;
    EcomCatDetailsFragment ecomCatDetailsFragment;
    public TrackOrderEcomAdapater(Context context){
        this.context=context;


    }

    public TrackOrderEcomAdapater(Context context, EcomCatDetailsFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }
    @NonNull
    @Override
    public TrackOrderEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_delivery_status,parent,false);
        TrackOrderEcomAdapater.HomeProfile homeProfile=new TrackOrderEcomAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull TrackOrderEcomAdapater.HomeProfile holder, int position) {
       /* holder.rvTopLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* EcomCategoryInsideCateogryFragment fragment2 = new EcomCategoryInsideCateogryFragment();
                FragmentManager fragmentManager = ecomCatDetailsFragment.getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*//*
            }
        });*/




    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        RelativeLayout rvTopLayout;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvTopLayout=itemView.findViewById(R.id.rvTopLayout);



        }
    }



}
