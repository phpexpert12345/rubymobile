package com.pet.rubymobile.drawer_ecommerce;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.pet.rubymobile.R;
import com.pet.rubymobile.home.ui.home.CategoryFirstAdapater;
import com.pet.rubymobile.home.ui.home.CategoryScndAdapater;
import com.pet.rubymobile.home.ui.home.FirstFragment;
import com.pet.rubymobile.home.ui.home.FirstViewPageAdapter;
import com.pet.rubymobile.home.ui.home.SecondFragment;

public class EcomCatDetailsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @BindView(R.id.rvCategoryDetails)
    RecyclerView rvCategoryDetails;

    CategoryEcomViewPgAdapter categoryEcomViewPgAdapter;
    CategoryDetailsEcomAdapater categoryDetailsEcomAdapater;

    @BindView(R.id.viewPager)
    ViewPager rvCategoryFirst;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;

    public EcomCatDetailsFragment() {

    }

    public static EcomCatDetailsFragment newInstance(String param1, String param2) {
        EcomCatDetailsFragment fragment = new EcomCatDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_ecom_cat_details, container, false);
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
        viewPageCalled();
        viewFinds();
    }


    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view) {
        getActivity().onBackPressed();
    }

    private void viewFinds() {
        categoryDetailsEcomAdapater = new CategoryDetailsEcomAdapater(getActivity(), EcomCatDetailsFragment.this);
        rvCategoryDetails.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvCategoryDetails.setAdapter(categoryDetailsEcomAdapater);
    }

    private void viewPageCalled() {
        categoryEcomViewPgAdapter = new CategoryEcomViewPgAdapter(getChildFragmentManager());
        categoryEcomViewPgAdapter.addFragment(new FirstFragment(), "");
        categoryEcomViewPgAdapter.addFragment(new SecondFragment(), "");
        rvCategoryFirst.setAdapter(categoryEcomViewPgAdapter);
        tab_layout.setupWithViewPager(rvCategoryFirst, true);
        rvCategoryFirst.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}