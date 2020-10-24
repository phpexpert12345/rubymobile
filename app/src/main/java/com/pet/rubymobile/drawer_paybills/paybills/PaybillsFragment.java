package com.pet.rubymobile.drawer_paybills.paybills;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.pet.rubymobile.drawer_paybills.electricity_payment.ElectrircityPayment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaybillsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaybillsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    AddNewInvoiceAdapter addNewInvoiceAdapter;

    @BindView(R.id.rvAddNewInvoice)
    RecyclerView rvAddNewInvoice;
    @BindView(R.id.cvUserDetails)
    CardView cvUserDetails;
    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;

    public PaybillsFragment() {

    }


    public static PaybillsFragment newInstance(String param1, String param2) {
        PaybillsFragment fragment = new PaybillsFragment();
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

        View view = inflater.inflate(R.layout.fragment_paybills, container, false);
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
        //for AddNewInvoice Data adapter
        addNewInvoiceAdapter = new AddNewInvoiceAdapter(getContext(), PaybillsFragment.this);
        rvAddNewInvoice.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvAddNewInvoice.setAdapter(addNewInvoiceAdapter);
    }

    @OnClick(R.id.cvUserDetails)
    public void cvUserDetailsClicked(View view) {
        ElectrircityPayment fragment2 = new ElectrircityPayment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.ivBack)
    public void backClicked(View view) {
        getActivity().onBackPressed();
    }
}