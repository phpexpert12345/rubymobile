package com.pet.rubymobile.drawer_ecommerce.myOrder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.orderDetails.OrderDetailsFragment;
import com.pet.rubymobile.drawer_ecommerce.purchaseOrder.PurchaseOrderFragment;
import com.pet.rubymobile.drawer_ecommerce.trackOrder.TrackOrderFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class MyOrderEcomAdapater extends RecyclerView.Adapter<MyOrderEcomAdapater.HomeProfile> {

    Context context;
    MyOrderFragment ecomCatDetailsFragment;

    public MyOrderEcomAdapater(Context context, MyOrderFragment ecomCatDetailsFragment) {
        this.context = context;
        this.ecomCatDetailsFragment = ecomCatDetailsFragment;

    }


    @NonNull
    @Override
    public MyOrderEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_my_order, parent, false);
        MyOrderEcomAdapater.HomeProfile homeProfile = new MyOrderEcomAdapater.HomeProfile(view);
        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderEcomAdapater.HomeProfile holder, int position) {
        holder.cvMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PurchaseOrderFragment fragment2 = new PurchaseOrderFragment();
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
        return 4;
    }

    public class HomeProfile extends RecyclerView.ViewHolder {
        CardView cvMyOrder;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvMyOrder = itemView.findViewById(R.id.cvMyOrder);


        }
    }


}
