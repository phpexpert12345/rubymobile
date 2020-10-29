package com.pet.rubymobile.deposit.transactionInfoNext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_paybills.billing_informations.BillingInformations;
import com.pet.rubymobile.drawer_paybills.electricity_payment.ElectricityPaymentAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TransactionInfoNextFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ElectricityPaymentAdapter electricityPaymentAdapter;

    @BindView(R.id.btnMainScreen)
    AppCompatButton btnMainScreen;

    public TransactionInfoNextFragment() {
        // Required empty public constructor
    }

   
    public static TransactionInfoNextFragment newInstance(String param1, String param2) {
        TransactionInfoNextFragment fragment = new TransactionInfoNextFragment();
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
        View view= inflater.inflate(R.layout.fragment_electrircity_payment, container, false);
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
       /* electricityPaymentAdapter = new ElectricityPaymentAdapter(getContext(), ElectrircityPayment.this);
        rvElectricityPaymt.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvElectricityPaymt.setAdapter(electricityPaymentAdapter);*/
    }

    @OnClick(R.id.btnMainScreen)
    public void btnMainScreenClicked(View  view){
       /* BillingInformations fragment2 = new BillingInformations();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();*/
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view){
        getActivity().onBackPressed();
    }
}