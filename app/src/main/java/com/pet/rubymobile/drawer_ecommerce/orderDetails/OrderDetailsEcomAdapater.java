package com.pet.rubymobile.drawer_ecommerce.orderDetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.EcomCatDetailsFragment;
import com.pet.rubymobile.drawer_ecommerce.trackOrder.TrackOrderFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class OrderDetailsEcomAdapater extends RecyclerView.Adapter<OrderDetailsEcomAdapater.HomeProfile> {

   Context context;
    OrderDetailsFragment ecomCatDetailsFragment;
    public OrderDetailsEcomAdapater(Context context,OrderDetailsFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }


    @NonNull
    @Override
    public OrderDetailsEcomAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_order_details,parent,false);
        OrderDetailsEcomAdapater.HomeProfile homeProfile=new OrderDetailsEcomAdapater.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsEcomAdapater.HomeProfile holder, int position) {
        holder.rvOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrackOrderFragment fragment2 = new TrackOrderFragment();
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
    public class HomeProfile extends RecyclerView.ViewHolder{
        RelativeLayout rvOrders;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvOrders=itemView.findViewById(R.id.rvOrders);



        }
    }



}
