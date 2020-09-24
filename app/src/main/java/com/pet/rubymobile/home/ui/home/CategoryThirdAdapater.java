package com.pet.rubymobile.home.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryThirdAdapater extends RecyclerView.Adapter<CategoryThirdAdapater.HomeProfile> {

   Context context;
    public CategoryThirdAdapater(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public CategoryThirdAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_category_third,parent,false);
        CategoryThirdAdapater.HomeProfile homeProfile=new CategoryThirdAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryThirdAdapater.HomeProfile holder, int position) {




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
