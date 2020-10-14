package com.pet.rubymobile.drawer_ecommerce.allCategorywithfilter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.EcomHomeFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.HomeProfile> {

   Context context;
   EcomHomeFragment ecomHomeFragment;

    public BrandAdapter(Context context){

        this.context=context;


    }
    @NonNull
    @Override
    public BrandAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_brand,parent,false);
        BrandAdapter.HomeProfile homeProfile=new BrandAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull BrandAdapter.HomeProfile holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 10;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{

        public HomeProfile(@NonNull View itemView) {
            super(itemView);




        }
    }



}
