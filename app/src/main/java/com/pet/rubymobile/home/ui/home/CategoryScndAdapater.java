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
import com.pet.rubymobile.home.ui.home.home.NameAndImagesClass;

import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryScndAdapater  extends RecyclerView.Adapter<CategoryScndAdapater.HomeProfile> {

   Context context;
   private List itemName;
    public CategoryScndAdapater(Context context,List itemName){
        this.context=context;
        this.itemName=itemName;

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
    holder.tvName.setText(itemName.get(position).toString());
    if (position==0){
        holder.ivCategory.setBackgroundResource(R.drawable.airtime_data);
    }else if (position==1){
        holder.ivCategory.setBackgroundResource(R.drawable.paytv);
    }else if (position==2){
        holder.ivCategory.setBackgroundResource(R.drawable.electricity);
    }else if (position==3){
        holder.ivCategory.setBackgroundResource(R.drawable.water);
    }else if (position==4){
        holder.ivCategory.setBackgroundResource(R.drawable.school_fees);
    }else if (position==5){
        holder.ivCategory.setBackgroundResource(R.drawable.taxes);
    }else if (position==6){
        holder.ivCategory.setBackgroundResource(R.drawable.airtime_data);
    }else if (position==7){
        holder.ivCategory.setBackgroundResource(R.drawable.paytv);
    }






    }

    @Override
    public int getItemCount() {
        return 8;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        AppCompatTextView tvName;
        AppCompatImageView ivCategory;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            ivCategory=itemView.findViewById(R.id.ivCategory);

        }
    }



}
