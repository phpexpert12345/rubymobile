package com.pet.rubymobile.drawer_ecommerce;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.home.ui.home.CategoryScndAdapater;
import com.pet.rubymobile.interfaces.ItemClickViewPositionListener;

import java.util.ArrayList;
import java.util.List;

public class EcomHomeFragment extends Fragment implements ItemClickViewPositionListener {
    @BindView(R.id.rvCategoryScnd)
    RecyclerView rvCategoryScnd;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    CategoryEcomAdapater categoryScndAdapater;
    private List itemName;

    public EcomHomeFragment() {
        // Required empty public constructor
    }

    public static EcomHomeFragment newInstance(String param1, String param2) {
        EcomHomeFragment fragment = new EcomHomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_ecom_home_fragmentn, container, false);
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
        itemName = new ArrayList();
        itemName.add("Beauty");
        itemName.add("Mobile Phone");
        itemName.add("Men's Fashion");
        itemName.add("Grocery");
        itemName.add("Buy Electronics");
        itemName.add("Women's Fashion");
        itemName.add("Sport Shoes");
        itemName.add("Kitchen");
        itemName.add("Beauty");
        itemName.add("Mobile Phone");
        itemName.add("Men's Fashion");
        itemName.add("Grocery");
        itemName.add("Buy Electronics");
        itemName.add("Women's Fashion");
        itemName.add("Sport Shoes");
        itemName.add("Kitchen");
        itemName.add("Kitchen");
        itemName.add("Beauty");
        itemName.add("Mobile Phone");
        itemName.add("Men's Fashion");
        categoryScndAdapater = new CategoryEcomAdapater(getActivity(), itemName);
        rvCategoryScnd.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        rvCategoryScnd.setAdapter(categoryScndAdapater);
        categoryScndAdapater.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Fragment fragment2 = new EcomCatDetailsFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}