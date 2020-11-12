package com.pet.rubymobile.drawer_ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.allCategorywithfilter.EcomCategoryInsideCateogryFragment;
import com.pet.rubymobile.drawer_ecommerce.singleDetails.SingleDetailsFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryInsideCategoryEcomAdapater extends RecyclerView.Adapter<CategoryInsideCategoryEcomAdapater.HomeProfile> {

    Context context;
    EcomCategoryInsideCateogryFragment ecomCategoryInsideCateogryFragment;

    public CategoryInsideCategoryEcomAdapater(Context context) {
        this.context = context;


    }

    public CategoryInsideCategoryEcomAdapater(Context context, EcomCategoryInsideCateogryFragment ecomCategoryInsideCateogryFragment) {
        this.context = context;
        this.ecomCategoryInsideCateogryFragment = ecomCategoryInsideCateogryFragment;

    }

    @NonNull
    @Override
    public CategoryInsideCategoryEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ecom_category_details, parent, false);
        CategoryInsideCategoryEcomAdapater.HomeProfile homeProfile = new CategoryInsideCategoryEcomAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryInsideCategoryEcomAdapater.HomeProfile holder, int position) {
        holder.rvTopLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SingleDetailsFragment fragment2 = new SingleDetailsFragment();
                FragmentManager fragmentManager = ecomCategoryInsideCateogryFragment.getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class HomeProfile extends RecyclerView.ViewHolder {
        RelativeLayout rvTopLayout;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvTopLayout = itemView.findViewById(R.id.rvTopLayout);


        }
    }


}
