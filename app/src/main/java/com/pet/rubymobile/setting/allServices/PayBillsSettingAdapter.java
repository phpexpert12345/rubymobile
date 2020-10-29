package com.pet.rubymobile.setting.allServices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_link_account.allServices.AllServiceFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PayBillsSettingAdapter extends RecyclerView.Adapter<PayBillsSettingAdapter.HomeProfile> {

   Context context;
    AllServiceSettingFragment allServiceFragment;
    public PayBillsSettingAdapter(Context context, AllServiceSettingFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public PayBillsSettingAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_allservices_function,parent,false);
        PayBillsSettingAdapter.HomeProfile homeProfile=new PayBillsSettingAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull PayBillsSettingAdapter.HomeProfile holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 9;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{

        public HomeProfile(@NonNull View itemView) {
            super(itemView);


        }
    }



}
