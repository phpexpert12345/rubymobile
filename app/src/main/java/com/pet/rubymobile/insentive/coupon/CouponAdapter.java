package com.pet.rubymobile.insentive.coupon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.insentive.giftDetails.GiftDetailsFragment;
import com.pet.rubymobile.notification.notificationMain.NotificationFragment;
import com.pet.rubymobile.notification.transactionDetails.TransactionDetailsFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.HomeProfile> {

    Context context;
    CouponFragment allServiceFragment;

    public CouponAdapter(Context context, CouponFragment allServiceFragment) {
        this.context = context;
        this.allServiceFragment = allServiceFragment;

    }

    @NonNull
    @Override
    public CouponAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_coupon, parent, false);
        CouponAdapter.HomeProfile homeProfile = new CouponAdapter.HomeProfile(view);
        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CouponAdapter.HomeProfile holder, int position) {
        holder.cvForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GiftDetailsFragment fragment2 = new GiftDetailsFragment();
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

    public class HomeProfile extends RecyclerView.ViewHolder {
        CardView cvForm;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvForm = itemView.findViewById(R.id.cvForm);

        }
    }


}
