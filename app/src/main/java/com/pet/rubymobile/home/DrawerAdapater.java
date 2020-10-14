package com.pet.rubymobile.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.EcomHomeFragment;
import com.pet.rubymobile.drawer_link_account.allServices.AllServiceFragment;
import com.pet.rubymobile.drawer_money_transfer.transfer.TransferFragment;
import com.pet.rubymobile.drawer_paybills.paybills.PaybillsFragment;
import com.pet.rubymobile.drawer_wallet.MyWallet;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DrawerAdapater extends RecyclerView.Adapter<DrawerAdapater.HomeProfile> {
    HomeActivity homeActivity;
    Context context;
    boolean flagOne = false;
    DrawerItemAdapater drawerItemAdapater;

    List flagOpenClose;
    List itemTitleName;

    public DrawerAdapater(Context context,HomeActivity homeActivity) {
        this.homeActivity=homeActivity;
        this.context = context;
        flagOpenClose=new ArrayList();
        itemTitleName=new ArrayList();

        itemTitleName.add("paybills");
        itemTitleName.add("Money Transfer/Receive");
        itemTitleName.add("Wallet");
        itemTitleName.add("Hotel Booking");
        itemTitleName.add("E-Commerce");
        itemTitleName.add("Gift Card");
        itemTitleName.add("My Setting");
        itemTitleName.add("Manage Group Friends");
        itemTitleName.add("Transaction History");
        itemTitleName.add("Loyality Points");
        itemTitleName.add("Agents");
        itemTitleName.add("Credit Facilities");
        itemTitleName.add("Other Application Features");
        for(int i=0;i<itemTitleName.size();i++){
            flagOpenClose.add(false);

        }

    }

    @NonNull
    @Override
    public HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_drawer, parent, false);
        HomeProfile homeProfile = new HomeProfile(view);


        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProfile holder, int position) {
        drawerItemAdapater = new DrawerItemAdapater(context);
        holder.rvMenuItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.rvMenuItem.setAdapter(drawerItemAdapater);
        holder.tvTitleName.setText(itemTitleName.get(position).toString());

        holder.tvTitleName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==4){
                    EcomHomeFragment ecomHomeFragment=new EcomHomeFragment();
                    homeActivity.callFragment(ecomHomeFragment)  ;
                }else if (position==2){
                    MyWallet ecomHomeFragment=new MyWallet();
                    homeActivity.callFragmentTopInvisible(ecomHomeFragment)  ;
                }else if (position==1){
                    TransferFragment ecomHomeFragment=new TransferFragment();
                    homeActivity.callFragmentFullScreen(ecomHomeFragment)  ;
                }else if (position==3){
                    AllServiceFragment allServiceFragment=new AllServiceFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment)  ;
                }else if (position==0){
                    PaybillsFragment allServiceFragment=new PaybillsFragment();
                    homeActivity.callFragmentFullScreen(allServiceFragment)  ;
                }

            }
        });


        holder.rvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (flagOpenClose.get(position).toString().equalsIgnoreCase("false")){
                   holder.rvMenuItem.setVisibility(View.VISIBLE);
                   flagOpenClose.set(position,true);
                   holder.ivDown.setVisibility(View.VISIBLE);
                   //notifyDataSetChanged();

               }else{
                   holder.rvMenuItem.setVisibility(View.GONE);
                   flagOpenClose.set(position,false);
                   holder.ivDown.setVisibility(View.GONE);
                   //notifyDataSetChanged();
               }
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemTitleName.size();
    }

    public class HomeProfile extends RecyclerView.ViewHolder {
        RecyclerView rvMenuItem;
        RelativeLayout rvTitle;
        AppCompatTextView tvTitleName;
        AppCompatImageView ivDown;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            rvMenuItem = itemView.findViewById(R.id.rvMenuItem);
            rvTitle = itemView.findViewById(R.id.rvTitle);
            tvTitleName = itemView.findViewById(R.id.tvTitleName);
            ivDown = itemView.findViewById(R.id.ivDown);


        }
    }


}
