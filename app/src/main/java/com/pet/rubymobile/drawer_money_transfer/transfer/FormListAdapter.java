package com.pet.rubymobile.drawer_money_transfer.transfer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.myOrder.MyOrderFragment;
import com.pet.rubymobile.drawer_ecommerce.purchaseOrder.PurchaseOrderFragment;
import com.pet.rubymobile.drawer_money_transfer.transferToRubyMobile.TransferToRubyMobileWalletFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class FormListAdapter extends RecyclerView.Adapter<FormListAdapter.HomeProfile> {

   Context context;
    TransferFragment ecomCatDetailsFragment;
    public FormListAdapter(Context context, TransferFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }


    @NonNull
    @Override
    public FormListAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_from_list,parent,false);
        FormListAdapter.HomeProfile homeProfile=new FormListAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull FormListAdapter.HomeProfile holder, int position) {
        holder.cvForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransferToRubyMobileWalletFragment fragment2 = new TransferToRubyMobileWalletFragment();
                FragmentManager fragmentManager = ecomCatDetailsFragment.getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



    }

    @Override
    public int getItemCount() {
        return 2;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        CardView cvForm;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvForm=itemView.findViewById(R.id.cvForm);



        }
    }



}
