package com.pet.rubymobile.home.ui.home.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.payment.PaymentFragment;
import com.pet.rubymobile.view.MainActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OperatorRechargeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;
    @BindView(R.id.relativeLayout_statusBar)
    RelativeLayout relativeLayoutStatusBar;
    @BindView(R.id.llAirtimeData)
    LinearLayout llAirtimeData;
    @BindView(R.id.llPayTv)
    LinearLayout llPayTv;
    @BindView(R.id.llWater)
    LinearLayout llWater;
    @BindView(R.id.llTaxes)
    LinearLayout llTaxes;
    @BindView(R.id.llElectricity)
    LinearLayout llElectricity;
    @BindView(R.id.btn_next)
    AppCompatButton btnNext;
    @BindView(R.id.tvTitle)
    AppCompatTextView tvTitle;

    private String mParam1;
    private String mParam2;
    private Context mContext;

    public OperatorRechargeFragment() {
        // Required empty public constructor
    }

    public static OperatorRechargeFragment newInstance(String param1, String param2) {
        OperatorRechargeFragment fragment = new OperatorRechargeFragment();
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
        View view = inflater.inflate(R.layout.fragment_operator_recharge, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity();
        getLayout();
    }

    private void getLayout() {
        switch (mParam1) {
            case "airtime_data":
                tvTitle.setText("Airtime and Data");
                llAirtimeData.setVisibility(View.VISIBLE);
                break;
            case "paytv":
                tvTitle.setText("PayTv");
                llPayTv.setVisibility(View.VISIBLE);
                break;
            case "electricity":
                tvTitle.setText("Electricity");
                llElectricity.setVisibility(View.VISIBLE);
                break;
            case "water":
                tvTitle.setText("Water");
                llWater.setVisibility(View.VISIBLE);
                break;
            case "taxes":
                tvTitle.setText("Taxes");
                llTaxes.setVisibility(View.VISIBLE);
                break;
            case "cab":
                break;
        }
    }

    @OnClick({R.id.ivBack, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                Objects.requireNonNull((MainActivity) mContext).onBackPressed();
                break;
            case R.id.btn_next:
                Fragment fragment = new PaymentFragment();
                callFragment(fragment);
                break;
        }
    }

    private void callFragment(Fragment fragment) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}