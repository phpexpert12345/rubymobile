package com.pet.rubymobile.drawer_ecommerce.deliveryAddress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.EcomCatDetailsFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeliveryAddressEcomAdapater extends RecyclerView.Adapter<DeliveryAddressEcomAdapater.HomeProfile> {

   Context context;
    EcomCatDetailsFragment ecomCatDetailsFragment;
    public DeliveryAddressEcomAdapater(Context context){
        this.context=context;


    }

    public DeliveryAddressEcomAdapater(Context context, EcomCatDetailsFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }
    @NonNull
    @Override
    public DeliveryAddressEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_delivery_address,parent,false);
        DeliveryAddressEcomAdapater.HomeProfile homeProfile=new DeliveryAddressEcomAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryAddressEcomAdapater.HomeProfile holder, int position) {
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
        return 2;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        RelativeLayout rvTopLayout;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvTopLayout=itemView.findViewById(R.id.rvTopLayout);



        }
    }



}
