package com.pet.rubymobile.notification.notificationMain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.notification.transactionDetails.TransactionDetailsFragment;
import com.pet.rubymobile.search.searchFirst.SearchFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.HomeProfile> {

     Context context;
    NotificationFragment allServiceFragment;
    public NotificationAdapter(Context context, NotificationFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public NotificationAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_notification,parent,false);
        NotificationAdapter.HomeProfile homeProfile=new NotificationAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.HomeProfile holder, int position) {
       holder.cvBankImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               TransactionDetailsFragment fragment2 = new TransactionDetailsFragment();
               FragmentManager fragmentManager = allServiceFragment.getParentFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.add(android.R.id.content, fragment2);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();
           }
       });



    }

    @Override
    public int getItemCount() {
        return 7;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
         CardView cvBankImage;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvBankImage=itemView.findViewById(R.id.cvBankImage);

        }
    }



}
