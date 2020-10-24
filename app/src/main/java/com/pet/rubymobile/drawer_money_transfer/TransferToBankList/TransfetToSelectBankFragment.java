package com.pet.rubymobile.drawer_money_transfer.TransferToBankList;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.home.ui.home.CategoryScndAdapater;


public class TransfetToSelectBankFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    BankListAdapter bankListAdapter;

    @BindView(R.id.rvBankList)
    RecyclerView rvBankList;

    public TransfetToSelectBankFragment() {
        // Required empty public constructor
    }


    public static TransfetToSelectBankFragment newInstance(String param1, String param2) {
        TransfetToSelectBankFragment fragment = new TransfetToSelectBankFragment();
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

        View view= inflater.inflate(R.layout.fragment_transfet_to_select_bank, container, false);
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
        bankListAdapter = new BankListAdapter(getContext());
        rvBankList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvBankList.setAdapter(bankListAdapter);
    }
    @OnClick(R.id.ivBack)
    public void ivBackClickde(View view){
        getActivity().onBackPressed();
    }
}