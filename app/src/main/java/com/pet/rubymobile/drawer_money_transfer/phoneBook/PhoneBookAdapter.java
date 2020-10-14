package com.pet.rubymobile.drawer_money_transfer.phoneBook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_money_transfer.transfer.TransferFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PhoneBookAdapter extends RecyclerView.Adapter<PhoneBookAdapter.HomeProfile> {

   Context context;
    PhoneBookFragment ecomCatDetailsFragment;
    public PhoneBookAdapter(Context context, PhoneBookFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }


    @NonNull
    @Override
    public PhoneBookAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_phone_book,parent,false);
        PhoneBookAdapter.HomeProfile homeProfile=new PhoneBookAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneBookAdapter.HomeProfile holder, int position) {
        /*holder.cvMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PurchaseOrderFragment fragment2 = new PurchaseOrderFragment();
                FragmentManager fragmentManager = ecomCatDetailsFragment.getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
*/



    }

    @Override
    public int getItemCount() {
        return 12;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        //CardView cvMyOrder;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            //cvMyOrder=itemView.findViewById(R.id.cvMyOrder);



        }
    }



}
