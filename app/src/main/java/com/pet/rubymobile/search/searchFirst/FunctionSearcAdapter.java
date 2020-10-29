package com.pet.rubymobile.search.searchFirst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.setting.allServices.AllServiceSettingFragment;
import com.pet.rubymobile.setting.settingNew.SettingFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class FunctionSearcAdapter extends RecyclerView.Adapter<FunctionSearcAdapter.HomeProfile> {

     Context context;
    SearchFragment allServiceFragment;
    public FunctionSearcAdapter(Context context, SearchFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public FunctionSearcAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_allservices_function,parent,false);
        FunctionSearcAdapter.HomeProfile homeProfile=new FunctionSearcAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull FunctionSearcAdapter.HomeProfile holder, int position) {
       holder.cvBankImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              /* SettingFragment fragment2 = new SettingFragment();
               FragmentManager fragmentManager = allServiceFragment.getParentFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.add(android.R.id.content, fragment2);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();*/
           }
       });



    }

    @Override
    public int getItemCount() {
        return 9;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
         CardView cvBankImage;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvBankImage=itemView.findViewById(R.id.cvBankImage);

        }
    }



}
