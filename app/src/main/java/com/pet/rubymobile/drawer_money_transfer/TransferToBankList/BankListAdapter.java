package com.pet.rubymobile.drawer_money_transfer.TransferToBankList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.HomeProfile> {

   Context context;
    public BankListAdapter(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public BankListAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_bank_list,parent,false);
        BankListAdapter.HomeProfile homeProfile=new BankListAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull BankListAdapter.HomeProfile holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 12;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{

        public HomeProfile(@NonNull View itemView) {
            super(itemView);


        }
    }



}
