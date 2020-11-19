package com.pet.rubymobile.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.util.ColorGenerator;
import com.pet.rubymobile.util.Helper;
import com.pet.rubymobile.util.TextDrawable;

import org.jetbrains.annotations.NotNull;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private Context mContext;
    private String[] nameList = {"Raj", "Rashmi", "Rahul", "komal", "Savita", "Arun"};
    private String[] lastnameList = {"Sir", "Gupta", "Kamal", "Puri", "Sharma", "Sir"};
    private String[] numberList = {"9876787675", "8978786554", "9234567854", "8889997878", "6667676767", "9876767676"};

    public ContactAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        holder.tvName.setText(nameList[position] + " " + lastnameList[position]);
        holder.tvNumber.setText(numberList[position]);
        try {
            TextDrawable.IBuilder mDrawableBuilder = TextDrawable.builder()
                    .beginConfig()
                    .textColor(0xffffffff)
                    .useFont(Typeface.createFromAsset(mContext.getAssets(), "fonts/lato_bold.ttf"))
                    .withBorder(5)
                    .endConfig()
                    .roundRect(100);
            TextDrawable drawable = mDrawableBuilder.build(Helper.fetchNameInitialsFromFullName(mContext, nameList[position] + " " + lastnameList[position]),
                    ColorGenerator.MATERIAL.getRandomColor());
            holder.ivCategory.setImageDrawable(drawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvName, tvNumber;
        AppCompatImageView ivCategory;

        ViewHolder(View itemView) {
            super(itemView);
            if (itemView != null) {
                tvName = itemView.findViewById(R.id.tvName);
                ivCategory = itemView.findViewById(R.id.ivCategory);
                tvNumber = itemView.findViewById(R.id.tvNumber);
            }
        }
    }
}