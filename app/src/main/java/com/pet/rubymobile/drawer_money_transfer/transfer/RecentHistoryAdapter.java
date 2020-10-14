package com.pet.rubymobile.drawer_money_transfer.transfer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecentHistoryAdapter extends RecyclerView.Adapter<RecentHistoryAdapter.HomeProfile> {

   Context context;
    TransferFragment ecomCatDetailsFragment;
    public RecentHistoryAdapter(Context context, TransferFragment ecomCatDetailsFragment){
        this.context=context;
        this.ecomCatDetailsFragment=ecomCatDetailsFragment;

    }


    @NonNull
    @Override
    public RecentHistoryAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recent_history,parent,false);
        RecentHistoryAdapter.HomeProfile homeProfile=new RecentHistoryAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentHistoryAdapter.HomeProfile holder, int position) {
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
        return 4;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
        //CardView cvMyOrder;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            //cvMyOrder=itemView.findViewById(R.id.cvMyOrder);



        }
    }



}
