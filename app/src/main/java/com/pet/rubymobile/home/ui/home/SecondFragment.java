package com.pet.rubymobile.home.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_money_transfer.transfer.TransferFragment;
import com.pet.rubymobile.insentive.coupon.CouponFragment;
import com.pet.rubymobile.receiveMoney.receiveMone.ReceiveMoneyFragment;
import com.pet.rubymobile.view.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.ivCategory)
    AppCompatImageView ivCategory;
    @BindView(R.id.rlRequestMoney)
    RelativeLayout rlRequestMoney;
    @BindView(R.id.ivCategory1)
    AppCompatImageView ivCategory1;
    @BindView(R.id.rlGoals)
    RelativeLayout rlGoals;
    @BindView(R.id.ivCategory2)
    AppCompatImageView ivCategory2;
    @BindView(R.id.rlGiftCards)
    RelativeLayout rlGiftCards;
    @BindView(R.id.ivCategory3)
    AppCompatImageView ivCategory3;
    private Context mContext;
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity();
    }

    @OnClick({R.id.rlRequestMoney, R.id.rlGoals, R.id.rlGiftCards})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlRequestMoney:
                Fragment scanCodeFragment = new ReceiveMoneyFragment();
                callFragment(scanCodeFragment);
                break;
            case R.id.rlGoals:
                break;
            case R.id.rlGiftCards:
                Fragment fragment = new CouponFragment();
                callFragment(fragment);
                break;
        }
    }

    private void callFragment(Fragment fragment) {
        FragmentManager manager = ((MainActivity) mContext).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}