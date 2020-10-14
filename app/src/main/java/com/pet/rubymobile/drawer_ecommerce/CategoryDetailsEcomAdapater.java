package com.pet.rubymobile.drawer_ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.allCategorywithfilter.EcomCategoryInsideCateogryFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryDetailsEcomAdapater extends RecyclerView.Adapter<CategoryDetailsEcomAdapater.HomeProfile> {

   Context context;
    EcomCatDetailsFragment ecomCatDetailsFragment;
    public CategoryDetailsEcomAdapater(Context context){
        this.context=context;


    }

    public CategoryDetailsEcomAdapater(Context context,EcomCatDetailsFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }
    @NonNull
    @Override
    public CategoryDetailsEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_ecom_category_details,parent,false);
        CategoryDetailsEcomAdapater.HomeProfile homeProfile=new CategoryDetailsEcomAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryDetailsEcomAdapater.HomeProfile holder, int position) {
        holder.rvTopLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EcomCategoryInsideCateogryFragment fragment2 = new EcomCategoryInsideCateogryFragment();
                FragmentManager fragmentManager = ecomCatDetailsFragment.getParentFragmentManager();
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
    public class HomeProfile extends RecyclerView.ViewHolder{
        RelativeLayout rvTopLayout;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvTopLayout=itemView.findViewById(R.id.rvTopLayout);



        }
    }



}
