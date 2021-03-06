package com.pet.rubymobile.drawer_ecommerce.deliveryAddress;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.cart.CartEcomAdapater;
import com.pet.rubymobile.drawer_ecommerce.payment.PaymentFragment;


public class DeliveryAddressFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.rvAddressList)
    RecyclerView rvAddressList;

    @BindView(R.id.llAddNewAddress)
    LinearLayout llAddNewAddress;

    DeliveryAddressEcomAdapater deliveryAddressEcomAdapater;

    public DeliveryAddressFragment() {
        // Required empty public constructor
    }


    public static DeliveryAddressFragment newInstance(String param1, String param2) {
        DeliveryAddressFragment fragment = new DeliveryAddressFragment();
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

        View view= inflater.inflate(R.layout.fragment_delivery_address, container, false);
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
        deliveryAddressEcomAdapater = new DeliveryAddressEcomAdapater(getActivity());
        rvAddressList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvAddressList.setAdapter(deliveryAddressEcomAdapater);
    }

    @OnClick(R.id.llAddNewAddress)
    public void llAddNewAddressClicked(View view){
        PaymentFragment fragment2 = new PaymentFragment();
        FragmentManager fragmentManager =getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view){
        getActivity().onBackPressed();
    }
}