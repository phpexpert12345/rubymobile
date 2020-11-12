package com.pet.rubymobile.drawer_ecommerce;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.interfaces.ItemClickViewPositionListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryEcomAdapater extends RecyclerView.Adapter<CategoryEcomAdapater.HomeProfile> {

    private Context context;
    private List itemName;
    private ItemClickViewPositionListener listener;

    public CategoryEcomAdapater(Context context, List itemName) {
        this.context = context;
        this.itemName = itemName;
    }

    @NonNull
    @Override
    public CategoryEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ecom_home, parent, false);
        CategoryEcomAdapater.HomeProfile homeProfile = new CategoryEcomAdapater.HomeProfile(view);
        return homeProfile;
    }


    public void setClickListener(ItemClickViewPositionListener itemClickListener) {
        this.listener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryEcomAdapater.HomeProfile holder, int position) {
        holder.tvName.setText(itemName.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class HomeProfile extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout rvTop;
        AppCompatTextView tvName;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvTop = itemView.findViewById(R.id.rvTop);
            tvName = itemView.findViewById(R.id.tvName);
            rvTop.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null)
                listener.onItemClick(view, getAdapterPosition());
        }
    }
}
