package com.pet.rubymobile.insentive.pointHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.insentive.incentives.IncentivesFragment;
import com.pet.rubymobile.insentive.insentiveNext.InsentiveNextFragment;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class ReceivePointsAdapter extends RecyclerView.Adapter<ReceivePointsAdapter.HomeProfile> {

     Context context;
    ReceivePointsFragment allServiceFragment;
    public ReceivePointsAdapter(Context context, ReceivePointsFragment allServiceFragment){
        this.context=context;
        this.allServiceFragment=allServiceFragment;

    }
    @NonNull
    @Override
    public ReceivePointsAdapter.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_incentives,parent,false);
        ReceivePointsAdapter.HomeProfile homeProfile=new ReceivePointsAdapter.HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull ReceivePointsAdapter.HomeProfile holder, int position) {
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
