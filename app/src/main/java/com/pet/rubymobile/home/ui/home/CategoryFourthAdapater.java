package com.pet.rubymobile.home.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryFourthAdapater extends RecyclerView.Adapter<CategoryFourthAdapater.HomeProfile> {

   Context context;
   private List itemName;
    public CategoryFourthAdapater(Context context,List itemName){
        this.context=context;
        this.itemName=itemName;

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
    holder.tvName.setText(itemName.get(position).toString());

    if (position==0){
        holder.ivCategory.setBackgroundResource(R.drawable.paytv);
    }else if (position==1){
        holder.ivCategory.setBackgroundResource(R.drawable.electricity);
    }else if (position==2){
        holder.ivCategory.setBackgroundResource(R.drawable.water);
    }
    else if (position==3){
        holder.ivCategory.setBackgroundResource(R.drawable.school_fees);
    }




    }

    @Override
    public int getItemCount() {
        return 4;
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
