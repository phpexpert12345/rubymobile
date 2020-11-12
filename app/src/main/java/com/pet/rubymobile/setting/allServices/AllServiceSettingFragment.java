package com.pet.rubymobile.setting.allServices;

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
import com.pet.rubymobile.drawer_link_account.allServices.AllServiceFragment;
import com.pet.rubymobile.drawer_link_account.allServices.AllServicesFunctionAdapter;
import com.pet.rubymobile.drawer_link_account.allServices.PayBillsAdapter;


public class AllServiceSettingFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    FunctionSettingAdapter functionSettingAdapter;
    PayBillsSettingAdapter payBillsSettingAdapter;

    @BindView(R.id.rvAllSrvcFnc)
    RecyclerView rvAllSrvcFnc;
    @BindView(R.id.rvPayBills)
    RecyclerView rvPayBills;

    public AllServiceSettingFragment() {

    }


    public static AllServiceSettingFragment newInstance(String param1, String param2) {
        AllServiceSettingFragment fragment = new AllServiceSettingFragment();
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

        View view = inflater.inflate(R.layout.fragment_all_service_setting, container, false);
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
        //for Function Data adapter
        functionSettingAdapter = new FunctionSettingAdapter(getActivity(), AllServiceSettingFragment.this);
        rvAllSrvcFnc.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvAllSrvcFnc.setAdapter(functionSettingAdapter);

        //for Function Data adapter
        payBillsSettingAdapter = new PayBillsSettingAdapter(getActivity(), AllServiceSettingFragment.this);
        rvPayBills.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvPayBills.setAdapter(payBillsSettingAdapter);

    }
}