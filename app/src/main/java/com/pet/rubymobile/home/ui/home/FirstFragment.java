package com.pet.rubymobile.home.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_link_account.allServices.AllServiceFragment;
import com.pet.rubymobile.drawer_money_transfer.transfer.TransferFragment;
import com.pet.rubymobile.drawer_wallet.MyWallet;
import com.pet.rubymobile.pay_and_scan.scan_code.ScanCodeFragment;


public class FirstFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.rlAddMoney)
    RelativeLayout rlAddMoney;

    public FirstFragment() {
        // Required empty public constructor
    }


    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.rlAddMoney)
    public void rlAddMoneyClicked(View view){
        MyWallet scanCodeFragment=new MyWallet();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.homeFrameTopInvisble, scanCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.rlFundTransefer)
    public void rlFundTranseferClicked(View view){
        TransferFragment scanCodeFragment=new TransferFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, scanCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @OnClick(R.id.rlPayments)
    public void rlPaymentsClicked(View view){
        AllServiceFragment scanCodeFragment=new AllServiceFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, scanCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}