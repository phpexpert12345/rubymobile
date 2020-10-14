package com.pet.rubymobile.drawer_link_account.linkAccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_link_account.bank.BankFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.HomeProfile> {

   Context context;

   LinkAccountFragment linkAccountFragment;
    public BankListAdapter(Context context,LinkAccountFragment linkAccountFragment){
        this.context=context;
        this.linkAccountFragment=linkAccountFragment;

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
      holder.cvBankImage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              BankFragment fragment2 = new BankFragment();
              FragmentManager fragmentManager = linkAccountFragment.getParentFragmentManager();
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
    public class HomeProfile extends RecyclerView.ViewHolder{
           CardView cvBankImage;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvBankImage=itemView.findViewById(R.id.cvBankImage);



        }
    }



}
