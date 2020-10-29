package com.pet.rubymobile.deposit.depositIntoTheWalletAfBank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.deposit.depositFees.DepositFeesFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class FoundsListAfBankAdapter extends RecyclerView.Adapter<FoundsListAfBankAdapter.HomeProfile> {

   Context context;
    DepositInToTheWalletAfBankFragment ecomCatDetailsFragment;
    public FoundsListAfBankAdapter(Context context, DepositInToTheWalletAfBankFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }


    @NonNull
    @Override
    public HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_founds_list,parent,false);
        HomeProfile homeProfile=new HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProfile holder, int position) {

        if (position==2){
            holder.ivAero.setVisibility(View.GONE);
            holder.ivInfo.setVisibility(View.VISIBLE);
        }else if (position==3){
            holder.ivAero.setVisibility(View.VISIBLE);
            holder.ivInfo.setVisibility(View.GONE);
        }else{
            holder.ivAero.setVisibility(View.GONE);
            holder.ivInfo.setVisibility(View.GONE);
        }
       /* holder.rvIdChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DepositFeesFragment fragment2 = new DepositFeesFragment();
                FragmentManager fragmentManager = ecomCatDetailsFragment.getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });*/



    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        //CardView cvMyOrder;

        AppCompatImageView ivInfo;
        AppCompatImageView ivAero;
        RelativeLayout rvIdChange;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            //cvMyOrder=itemView.findViewById(R.id.cvMyOrder);
            ivInfo=itemView.findViewById(R.id.ivInfo);
            ivAero=itemView.findViewById(R.id.ivAero);
            rvIdChange=itemView.findViewById(R.id.rvIdChange);




        }
    }



}
