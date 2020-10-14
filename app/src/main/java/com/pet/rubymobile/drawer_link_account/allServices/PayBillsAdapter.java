package com.pet.rubymobile.drawer_link_account.allServices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PayBillsAdapter extends RecyclerView.Adapter<PayBillsAdapter.HomeProfile> {

   Context context;
    AllServiceFragment allServiceFragment;
    public PayBillsAdapter(Context context,AllServiceFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public PayBillsAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_allservices_function,parent,false);
        PayBillsAdapter.HomeProfile homeProfile=new PayBillsAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull PayBillsAdapter.HomeProfile holder, int position) {




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
