package com.pet.rubymobile.home.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.interfaces.ItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperatorAdapter extends RecyclerView.Adapter<OperatorAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<String> operatorList;
    private int[] finalImgList;
    private ItemClickListener listener;

    public OperatorAdapter(Context context, ArrayList<String> operatorList, int[] finalImgList) {
        this.mContext = context;
        this.operatorList = operatorList;
        this.finalImgList = finalImgList;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_operator, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvOperatorName.setText(operatorList.get(position));
        holder.ivOperator.setImageResource(finalImgList[position]);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return operatorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView tvOperatorName;
        AppCompatImageView ivOperator;

        ViewHolder(View itemView) {
            super(itemView);
            tvOperatorName = itemView.findViewById(R.id.tvOperatorName);
            ivOperator = itemView.findViewById(R.id.ivOperator);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null)
                listener.onItemClick(view, getAdapterPosition());
        }
    }
}