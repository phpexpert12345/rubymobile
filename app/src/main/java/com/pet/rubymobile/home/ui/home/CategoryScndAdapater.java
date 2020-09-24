package com.pet.rubymobile.home.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pet.rubymobile.R;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryScndAdapater  extends RecyclerView.Adapter<CategoryScndAdapater.HomeProfile> {

   Context context;
    public CategoryScndAdapater(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public CategoryScndAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_category_scnd,parent,false);
        CategoryScndAdapater.HomeProfile homeProfile=new CategoryScndAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryScndAdapater.HomeProfile holder, int position) {




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
