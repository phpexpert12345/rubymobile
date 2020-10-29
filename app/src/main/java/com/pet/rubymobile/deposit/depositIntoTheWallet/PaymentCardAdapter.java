package com.pet.rubymobile.deposit.depositIntoTheWallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentCardAdapter extends RecyclerView.Adapter<PaymentCardAdapter.HomeProfile> {

   Context context;
    public PaymentCardAdapter(Context context){
        this.context=context;

    }
    @NonNull
    @Override
    public HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_payment_card,parent,false);
        HomeProfile homeProfile=new HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProfile holder, int position) {
    if (position==0){
      holder.ivBankImage.setBackgroundResource(R.drawable.card_inter);
    }else if (position==1){
        holder.ivBankImage.setBackgroundResource(R.drawable.visa);
    }else if (position==2){
        holder.ivBankImage.setBackgroundResource(R.drawable.money);
    }



    }

    @Override
    public int getItemCount() {
        return 3;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
    AppCompatImageView ivBankImage;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            ivBankImage=itemView.findViewById(R.id.ivBankImage);


        }
    }



}
