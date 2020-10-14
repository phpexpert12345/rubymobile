package com.pet.rubymobile.drawer_link_account.atm_card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_link_account.bank.BankFragment;
import com.pet.rubymobile.drawer_link_account.debit_card.DebitCardFragment;
import com.pet.rubymobile.drawer_link_account.linkAccount.LinkAccountFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class AtmCardAdapter extends RecyclerView.Adapter<AtmCardAdapter.HomeProfile> {

   Context context;

   AtmCardFragment linkAccountFragment;
    public AtmCardAdapter(Context context, AtmCardFragment linkAccountFragment){
        this.context=context;
        this.linkAccountFragment=linkAccountFragment;

    }
    @NonNull
    @Override
    public AtmCardAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_bank_list,parent,false);
        AtmCardAdapter.HomeProfile homeProfile=new AtmCardAdapter.HomeProfile(view);
        //this is new


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull AtmCardAdapter.HomeProfile holder, int position) {
      holder.cvBankImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebitCardFragment fragment2 = new DebitCardFragment();
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
