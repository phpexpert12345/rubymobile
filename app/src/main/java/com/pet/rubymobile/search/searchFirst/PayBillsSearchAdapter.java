package com.pet.rubymobile.search.searchFirst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.setting.allServices.AllServiceSettingFragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PayBillsSearchAdapter extends RecyclerView.Adapter<PayBillsSearchAdapter.HomeProfile> {

   Context context;
    SearchFragment allServiceFragment;
    public PayBillsSearchAdapter(Context context, SearchFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public PayBillsSearchAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_allservices_function,parent,false);
        PayBillsSearchAdapter.HomeProfile homeProfile=new PayBillsSearchAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull PayBillsSearchAdapter.HomeProfile holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 3;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{

        public HomeProfile(@NonNull View itemView) {
            super(itemView);


        }
    }



}
