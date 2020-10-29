package com.pet.rubymobile.setting.allServices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_link_account.allServices.AllServiceFragment;
import com.pet.rubymobile.drawer_link_account.linkAccount.LinkAccountFragment;
import com.pet.rubymobile.setting.settingNew.SettingFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class FunctionSettingAdapter extends RecyclerView.Adapter<FunctionSettingAdapter.HomeProfile> {

     Context context;
    AllServiceSettingFragment allServiceFragment;
    public FunctionSettingAdapter(Context context, AllServiceSettingFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public FunctionSettingAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_allservices_function,parent,false);
        FunctionSettingAdapter.HomeProfile homeProfile=new FunctionSettingAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull FunctionSettingAdapter.HomeProfile holder, int position) {
       holder.cvBankImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SettingFragment fragment2 = new SettingFragment();
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
        return 3;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
         CardView cvBankImage;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvBankImage=itemView.findViewById(R.id.cvBankImage);

        }
    }



}
