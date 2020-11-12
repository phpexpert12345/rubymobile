package com.pet.rubymobile.home.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryFirstAdapater extends RecyclerView.Adapter<CategoryFirstAdapater.HomeProfile> {

   Context context;
    public CategoryFirstAdapater(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public CategoryFirstAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_category_first,parent,false);
        CategoryFirstAdapater.HomeProfile homeProfile=new CategoryFirstAdapater.HomeProfile(view);
        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryFirstAdapater.HomeProfile holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
        }
    }
}
