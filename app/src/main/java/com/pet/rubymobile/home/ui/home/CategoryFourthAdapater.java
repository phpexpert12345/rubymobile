package com.pet.rubymobile.home.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryFourthAdapater extends RecyclerView.Adapter<CategoryFourthAdapater.HomeProfile> {

   Context context;
    public CategoryFourthAdapater(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public CategoryFourthAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_category_fourth,parent,false);
        CategoryFourthAdapater.HomeProfile homeProfile=new CategoryFourthAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryFourthAdapater.HomeProfile holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{

        public HomeProfile(@NonNull View itemView) {
            super(itemView);


        }
    }



}
