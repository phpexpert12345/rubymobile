package com.pet.rubymobile.drawer_money_transfer.transferTo;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_money_transfer.transferToRubyMobileNext.TransferToRubyMobileWalletNext;


public class TransferToFragment extends Fragment {

    private String mParam1;
    private String mParam2;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.btnNext)
    AppCompatButton btnNext;

    public TransferToFragment() {

    }

    public static TransferToFragment newInstance(String param1, String param2) {
        TransferToFragment fragment = new TransferToFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfer_to, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnNext)
    public void btnNextClicked(View view) {
        TransferToRubyMobileWalletNext transferFragment = new TransferToRubyMobileWalletNext();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, transferFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view) {
        getActivity().onBackPressed();
    }
}