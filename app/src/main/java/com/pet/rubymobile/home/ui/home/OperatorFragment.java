package com.pet.rubymobile.home.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.home.ui.home.home.OperatorRechargeFragment;
import com.pet.rubymobile.interfaces.ItemClickListener;
import com.pet.rubymobile.view.MainActivity;
import com.pet.rubymobile.view.fragments.SchoolFeeFragment;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OperatorFragment extends Fragment implements ItemClickListener {

    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;
    @BindView(R.id.relativeLayout_statusBar)
    RelativeLayout relativeLayoutStatusBar;
    @BindView(R.id.rvOperator)
    RecyclerView rvOperator;
    @BindView(R.id.tvTitle)
    AppCompatTextView tvTitle;
    @BindView(R.id.etSearch)
    AppCompatEditText etSearch;
    @BindView(R.id.ivSearch)
    AppCompatImageView ivSearch;
    private Context mContext;
    private ArrayList<String> operatorList;
    private int[] finalImgList;
    private String type;

    public OperatorFragment(ArrayList<String> operatorList, int[] finalImgList, String type) {
        this.operatorList = operatorList;
        this.finalImgList = finalImgList;
        this.type = type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operator, container, false);
        ButterKnife.bind(this, view);
        mContext = getActivity();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvOperator.setLayoutManager(new LinearLayoutManager(mContext));
        OperatorAdapter adapter = new OperatorAdapter(mContext, operatorList, finalImgList);
        rvOperator.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @OnClick(R.id.ivBack)
    public void onClick() {
        Objects.requireNonNull((MainActivity) mContext).onBackPressed();
    }

    @OnClick(R.id.ivSearch)
    public void onSearchClick() {
        etSearch.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(View view, int adapterPosition) {
//        if (type.equalsIgnoreCase("electricity")) {
        //        }
        if (type.equalsIgnoreCase("school_fee")) {
            Fragment fragment = SchoolFeeFragment.newInstance(type, "");
            callFragment(fragment);
        } else {
            Fragment fragment = OperatorRechargeFragment.newInstance(type, "");
            callFragment(fragment);
        }
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = ((MainActivity) mContext).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
