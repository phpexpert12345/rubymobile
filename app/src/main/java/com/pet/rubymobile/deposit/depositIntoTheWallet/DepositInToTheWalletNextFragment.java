package com.pet.rubymobile.deposit.depositIntoTheWallet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;


public class DepositInToTheWalletNextFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    BankListAdapter bankListAdapter;
    PaymentCardAdapter paymentCardAdapter;

    @BindView(R.id.rvBankList)
    RecyclerView rvBankList;
    @BindView(R.id.rvCardList)
    RecyclerView rvCardList;

    public DepositInToTheWalletNextFragment() {
        // Required empty public constructor
    }


    public static DepositInToTheWalletNextFragment newInstance(String param1, String param2) {
        DepositInToTheWalletNextFragment fragment = new DepositInToTheWalletNextFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_deposit_in_to_the_wallet2, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewFinds();
    }

    private void viewFinds() {
        bankListAdapter = new BankListAdapter(getContext(),DepositInToTheWalletNextFragment.this);
        rvBankList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvBankList.setAdapter(bankListAdapter);


        paymentCardAdapter = new PaymentCardAdapter(getContext());
        rvCardList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvCardList.setAdapter(paymentCardAdapter);
    }
}