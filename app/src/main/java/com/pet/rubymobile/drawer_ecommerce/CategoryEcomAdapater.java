package com.pet.rubymobile.drawer_ecommerce;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryEcomAdapater extends RecyclerView.Adapter<CategoryEcomAdapater.HomeProfile> {

   Context context;
   EcomHomeFragment ecomHomeFragment;

    public CategoryEcomAdapater(Context context,EcomHomeFragment ecomHomeFragment){
        this.ecomHomeFragment=ecomHomeFragment;
        this.context=context;


    }
    @NonNull
    @Override
    public CategoryEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_ecom_home,parent,false);
        CategoryEcomAdapater.HomeProfile homeProfile=new CategoryEcomAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryEcomAdapater.HomeProfile holder, int position) {
         holder.rvTop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 EcomCatDetailsFragment fragment2 = new EcomCatDetailsFragment();
                 FragmentManager fragmentManager = ecomHomeFragment.getParentFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.add(R.id.home_frame_layout, fragment2);
                 fragmentTransaction.addToBackStack(null);
                 fragmentTransaction.commit();



                /* EcomCatDetailsFragment ecomCatDetailsFragment=new EcomCatDetailsFragment();
                 FragmentManager fragmentManager = ecomCatDetailsFragment.getActivity().getSupportFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.add(R.id.home_frame_layout, ecomCatDetailsFragment);
                 fragmentTransaction.commit();*/
             }
         });



    }

    @Override
    public int getItemCount() {
        return 20;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
              RelativeLayout rvTop;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvTop=itemView.findViewById(R.id.rvTop);



        }
    }



}
