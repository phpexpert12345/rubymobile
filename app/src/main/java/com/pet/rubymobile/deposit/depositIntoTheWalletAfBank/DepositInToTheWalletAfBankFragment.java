package com.pet.rubymobile.deposit.depositIntoTheWalletAfBank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.deposit.transactionInfo.TransactionInfoFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DepositInToTheWalletAfBankFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.rvFounds)
    RecyclerView rvFounds;

    FoundsListAfBankAdapter recentHistoryAdapter;

    @BindView(R.id.btnNext)
    AppCompatButton btnNext;

    public DepositInToTheWalletAfBankFragment() {

    }


    public static DepositInToTheWalletAfBankFragment newInstance(String param1, String param2) {
        DepositInToTheWalletAfBankFragment fragment = new DepositInToTheWalletAfBankFragment();
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

        View view= inflater.inflate(R.layout.fragment_deposit_into_theafbank_wallet , container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewFinds();
    }

    private void viewFinds() {
        recentHistoryAdapter = new FoundsListAfBankAdapter(getContext(), DepositInToTheWalletAfBankFragment.this);
        rvFounds.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvFounds.setAdapter(recentHistoryAdapter);
    }

    @OnClick(R.id.btnNext)
    public void btnNextClicked(View view){
        TransactionInfoFragment fragment2 = new TransactionInfoFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}