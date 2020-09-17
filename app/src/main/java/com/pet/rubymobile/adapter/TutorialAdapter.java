package com.pet.rubymobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.PagerAdapter;

import com.pet.rubymobile.R;
import com.pet.rubymobile.model.TutorialModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TutorialAdapter extends PagerAdapter {
    @BindView(R.id.acv_image)
    AppCompatImageView acvImage;
    @BindView(R.id.actv_title)
    AppCompatTextView actvTitle;
    @BindView(R.id.actv_description)
    AppCompatTextView actvDescription;
    private ArrayList<TutorialModel> mData;
    private LayoutInflater mLayoutInflater;

    public TutorialAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setList(ArrayList<TutorialModel> mData) {
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_tutorial_screen, container, false);
        ButterKnife.bind(this, itemView);
        acvImage.setImageResource(mData.get(position).getFileName());
        actvTitle.setText(mData.get(position).getTextTitle());
        actvDescription.setText(mData.get(position).getTextContent());
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
