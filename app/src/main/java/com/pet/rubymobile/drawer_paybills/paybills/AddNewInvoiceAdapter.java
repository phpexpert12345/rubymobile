package com.pet.rubymobile.drawer_paybills.paybills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_paybills.electricity_payment_next.ElectricityPaymentNext;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class AddNewInvoiceAdapter extends RecyclerView.Adapter<AddNewInvoiceAdapter.HomeProfile> {

    Context context;
    PaybillsFragment paybillsFragment;

    public AddNewInvoiceAdapter(Context context, PaybillsFragment paybillsFragment) {
        this.context = context;
        this.paybillsFragment = paybillsFragment;

    }

    @NonNull
    @Override
    public AddNewInvoiceAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_allservices_function, parent, false);
        AddNewInvoiceAdapter.HomeProfile homeProfile = new AddNewInvoiceAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull AddNewInvoiceAdapter.HomeProfile holder, int position) {
        if (position == 0) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.airtime_data);
        } else if (position == 1) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.paytv);
        }else if (position == 2) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.electricity);
        }else if (position == 3) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.school_fees);
        }else if (position == 4) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.taxes);
        }else if (position == 5) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.airtime_data);
        }else if (position == 6) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.water);
        }else if (position == 7) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.paytv);
        }else if (position == 8) {
            holder.ivAddNewInvoice.setBackgroundResource(R.drawable.electricity);
        }


        holder.llTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ElectricityPaymentNext fragment2 = new ElectricityPaymentNext();
                FragmentManager fragmentManager = paybillsFragment.getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class HomeProfile extends RecyclerView.ViewHolder {
        LinearLayout llTop;
        AppCompatImageView ivAddNewInvoice;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            llTop = itemView.findViewById(R.id.llTop);
            ivAddNewInvoice = itemView.findViewById(R.id.ivAddNewInvoice);

        }
    }


}
