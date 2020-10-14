package com.pet.rubymobile.drawer_paybills.paybills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddNewInvoiceAdapter extends RecyclerView.Adapter<AddNewInvoiceAdapter.HomeProfile> {

   Context context;
    PaybillsFragment paybillsFragment;
    public AddNewInvoiceAdapter(Context context, PaybillsFragment paybillsFragment){
        this.context=context;
        this.paybillsFragment=paybillsFragment;

    }
    @NonNull
    @Override
    public AddNewInvoiceAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_allservices_function,parent,false);
        AddNewInvoiceAdapter.HomeProfile homeProfile=new AddNewInvoiceAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull AddNewInvoiceAdapter.HomeProfile holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 9;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{

        public HomeProfile(@NonNull View itemView) {
            super(itemView);


        }
    }



}
