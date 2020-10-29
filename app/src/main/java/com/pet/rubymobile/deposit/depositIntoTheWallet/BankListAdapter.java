package com.pet.rubymobile.deposit.depositIntoTheWallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.deposit.depositFees.DepositFeesFragment;
import com.pet.rubymobile.deposit.depositIntoTheWalletAfBank.DepositInToTheWalletAfBankFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.HomeProfile> {

   Context context;
   DepositInToTheWalletNextFragment depositInToTheWalletNextFragment;
    public BankListAdapter(Context context,DepositInToTheWalletNextFragment depositInToTheWalletNextFragment){
        this.context=context;
        this.depositInToTheWalletNextFragment=depositInToTheWalletNextFragment;

    }
    @NonNull
    @Override
    public HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_banklist_deposit,parent,false);
        HomeProfile homeProfile=new HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProfile holder, int position) {
       if (position==0){
           holder.ivBankImage.setBackgroundResource(R.drawable.kotak_ban);
       }else if (position==1){
           holder.ivBankImage.setBackgroundResource(R.drawable.sbi_bank);
       }else if (position==2){
           holder.ivBankImage.setBackgroundResource(R.drawable.kotak_ban);
       }else if (position==3){
           holder.ivBankImage.setBackgroundResource(R.drawable.kotak_ban);
       }else if (position==4){
           holder.ivBankImage.setBackgroundResource(R.drawable.sbi_bank);
       }else if (position==5){
           holder.ivBankImage.setBackgroundResource(R.drawable.kotak_ban);
       }

       holder.ivBankImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DepositInToTheWalletAfBankFragment fragment2 = new DepositInToTheWalletAfBankFragment();
               FragmentManager fragmentManager = depositInToTheWalletNextFragment.getParentFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.add(android.R.id.content, fragment2);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();
           }
       });



    }

    @Override
    public int getItemCount() {
        return 6;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
     AppCompatImageView ivBankImage;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            ivBankImage=itemView.findViewById(R.id.ivBankImage);


        }
    }



}
