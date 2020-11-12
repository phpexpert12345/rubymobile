package com.pet.rubymobile.home.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryThirdAdapater extends RecyclerView.Adapter<CategoryThirdAdapater.HomeProfile> {

    Context context;

    private List itemName;

    public CategoryThirdAdapater(Context context, List itemName) {
        this.context = context;
        this.itemName = itemName;

    }

    @NonNull
    @Override
    public CategoryThirdAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_third, parent, false);
        CategoryThirdAdapater.HomeProfile homeProfile = new CategoryThirdAdapater.HomeProfile(view);
        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryThirdAdapater.HomeProfile holder, int position) {
        if (position == 0) {
            holder.ivCategory.setBackgroundResource(R.drawable.main_slider);
        } else if (position == 1) {
            holder.ivCategory.setBackgroundResource(R.drawable.main_slider_one);
        } else if (position == 2) {
            holder.ivCategory.setBackgroundResource(R.drawable.main_slider);
        } else if (position == 3) {
            holder.ivCategory.setBackgroundResource(R.drawable.main_slider_one);
        } else {
            holder.ivCategory.setBackgroundResource(R.drawable.main_slider);
        }


    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class HomeProfile extends RecyclerView.ViewHolder {
        AppCompatImageView ivCategory;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            ivCategory = itemView.findViewById(R.id.ivCategory);
        }
    }
}
