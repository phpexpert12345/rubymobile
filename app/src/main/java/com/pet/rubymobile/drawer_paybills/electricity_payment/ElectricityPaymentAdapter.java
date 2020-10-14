package com.pet.rubymobile.drawer_paybills.electricity_payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_money_transfer.phoneBook.PhoneBookFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElectricityPaymentAdapter extends RecyclerView.Adapter<ElectricityPaymentAdapter.HomeProfile> {

   Context context;
    ElectrircityPayment electrircityPayment;
    public ElectricityPaymentAdapter(Context context, ElectrircityPayment electrircityPayment){
        this.context=context;
        this.electrircityPayment=electrircityPayment;

    }


    @NonNull
    @Override
    public ElectricityPaymentAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_electric_payment,parent,false);
        ElectricityPaymentAdapter.HomeProfile homeProfile=new ElectricityPaymentAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull ElectricityPaymentAdapter.HomeProfile holder, int position) {
        /*holder.cvMyOrder.setOnClickListener(new View.OnClickListener() {
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
*/



    }

    @Override
    public int getItemCount() {
        return 12;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        //CardView cvMyOrder;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            //cvMyOrder=itemView.findViewById(R.id.cvMyOrder);



        }
    }



}
