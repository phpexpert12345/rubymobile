package com.pet.rubymobile.withdraw.transactionInformation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransactionInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionInfoFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TransactionInfoFragment() {
        // Required empty public constructor
    }


    public static TransactionInfoFragment newInstance(String param1, String param2) {
        TransactionInfoFragment fragment = new TransactionInfoFragment();
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
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_transaction_info2, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
}