package com.pet.rubymobile.drawer_link_account.linkAccount;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_link_account.bank.BankFragment;
import com.pet.rubymobile.interfaces.ItemClickViewPositionListener;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.HomeProfile> {

    private Context context;
    private ItemClickViewPositionListener listener;

    public BankListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BankListAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bank_list, parent, false);
        BankListAdapter.HomeProfile homeProfile = new BankListAdapter.HomeProfile(view);
        return homeProfile;
    }

    public void setClickListener(ItemClickViewPositionListener itemClickListener) {
        this.listener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull BankListAdapter.HomeProfile holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class HomeProfile extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cvBankImage;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvBankImage = itemView.findViewById(R.id.cvBankImage);
            cvBankImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null)
                listener.onItemClick(view, getAdapterPosition());
        }
    }
}
