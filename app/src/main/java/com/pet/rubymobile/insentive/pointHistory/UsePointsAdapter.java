package com.pet.rubymobile.insentive.pointHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class UsePointsAdapter extends RecyclerView.Adapter<UsePointsAdapter.HomeProfile> {

     Context context;
    UsePointsFragment allServiceFragment;
    public UsePointsAdapter(Context context, UsePointsFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public UsePointsAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_incentives,parent,false);
        UsePointsAdapter.HomeProfile homeProfile=new UsePointsAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull UsePointsAdapter.HomeProfile holder, int position) {
       holder.cvForm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             /*  InsentiveNextFragment fragment2 = new InsentiveNextFragment();
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
        return 6;
    }
    public class HomeProfile extends RecyclerView.ViewHolder{
         CardView cvForm;
        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            cvForm=itemView.findViewById(R.id.cvForm);

        }
    }



}
