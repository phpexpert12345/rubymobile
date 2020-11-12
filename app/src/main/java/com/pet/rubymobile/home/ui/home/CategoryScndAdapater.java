package com.pet.rubymobile.home.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.home.HomeActivity;
import com.pet.rubymobile.home.ui.home.home.NameAndImagesClass;
import com.pet.rubymobile.view.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryScndAdapater extends RecyclerView.Adapter<CategoryScndAdapater.HomeProfile> {

    Context context;
    private List itemName;

    public CategoryScndAdapater(Context context, List itemName) {
        this.context = context;
        this.itemName = itemName;
    }

    @NonNull
    @Override
    public CategoryScndAdapater.HomeProfile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_scnd, parent, false);
        CategoryScndAdapater.HomeProfile homeProfile = new CategoryScndAdapater.HomeProfile(view);
        return homeProfile;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryScndAdapater.HomeProfile holder, int position) {
        holder.tvName.setText(itemName.get(position).toString());
        ArrayList<String> operatorList = new ArrayList();
        int[] imgList = new int[0];
        String type = "";
        try {
            if (position == 0) {
                type = "airtime_data";
                if (operatorList.size() > 0)
                    operatorList.clear();
                operatorList.add("Airtel");
                operatorList.add("MTN Uganda");
                operatorList.add("Africell");
                imgList = new int[]{R.drawable.ic_airtel, R.drawable.ic_mtn_uganda, R.drawable.ic_africell};
                holder.ivCategory.setBackgroundResource(R.drawable.airtime_data);
            } else if (position == 1) {
                type = "paytv";
                if (operatorList.size() > 0)
                    operatorList.clear();
                operatorList.add("DSTV & GOtv");
                operatorList.add("Star DTV (StarTimes");
                operatorList.add("ZUKU");
                operatorList.add("AZAM");
                imgList = new int[]{R.drawable.ic_taxes_kcca, R.drawable.ic_taxes_kcca, R.drawable.ic_taxes_kcca, R.drawable.ic_taxes_kcca};
                holder.ivCategory.setBackgroundResource(R.drawable.paytv);
            } else if (position == 2) {
                type = "electricity";
                operatorList.add("UMEME Yaka");
                operatorList.add("UMEME Postpaid");
                imgList = new int[]{R.drawable.ic_taxes_kcca, R.drawable.ic_taxes_kcca};
                holder.ivCategory.setBackgroundResource(R.drawable.electricity);
            } else if (position == 3) {
                type = "water";
                holder.ivCategory.setBackgroundResource(R.drawable.water);
            } else if (position == 4) {
                type = "school_fee";
                holder.ivCategory.setBackgroundResource(R.drawable.school_fees);
            } else if (position == 5) {
                type = "taxes";
                if (operatorList.size() > 0)
                    operatorList.clear();
                operatorList.add("URA");
                operatorList.add("KCCA");
                imgList = new int[]{R.drawable.ic_ura, R.drawable.ic_taxes_kcca};
                holder.ivCategory.setBackgroundResource(R.drawable.taxes);
            } else if (position == 6) {
                type = "cab";
                holder.ivCategory.setBackgroundResource(R.drawable.airtime_data); //cab icon
            }/* else if (position == 7) {
                holder.ivCategory.setBackgroundResource(R.drawable.paytv);
            }*/

            int[] finalImgList = imgList;
            String finalType = type;
            holder.rlItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = new OperatorFragment(operatorList, finalImgList, finalType);
                    callFragment(fragment);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = ((MainActivity) context).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }

    public class HomeProfile extends RecyclerView.ViewHolder {
        AppCompatTextView tvName;
        AppCompatImageView ivCategory;
        RelativeLayout rlItem;

        public HomeProfile(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            ivCategory = itemView.findViewById(R.id.ivCategory);
            rlItem = itemView.findViewById(R.id.rlItem);
        }
    }
}
