package com.pet.rubymobile.drawer_ecommerce.singleDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.android.material.tabs.TabLayout;
import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.CategoryEcomViewPgAdapter;
import com.pet.rubymobile.drawer_ecommerce.allCategorywithfilter.EcomCategoryInsideCateogryFragment;
import com.pet.rubymobile.drawer_ecommerce.cart.CartFragment;
import com.pet.rubymobile.home.ui.home.CategoryFirstAdapater;
import com.pet.rubymobile.home.ui.home.FirstFragment;
import com.pet.rubymobile.home.ui.home.FirstViewPageAdapter;
import com.pet.rubymobile.home.ui.home.SecondFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingleDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingleDetailsFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    CategoryEcomViewPgAdapter categoryEcomViewPgAdapter;
    @BindView(R.id.viewPager)
    ViewPager rvCategoryFirst;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;


    @BindView(R.id.btnBuyNow)
    AppCompatButton btnBuyNow;

    public SingleDetailsFragment() {
        // Required empty public constructor
    }


    public static SingleDetailsFragment newInstance(String param1, String param2) {
        SingleDetailsFragment fragment = new SingleDetailsFragment();
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
        View view = inflater.inflate(R.layout.fragment_single_details, container, false);
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
        viewPagerCallForImages();
    }

    private void viewPagerCallForImages() {
        categoryEcomViewPgAdapter = new CategoryEcomViewPgAdapter(getChildFragmentManager());
        categoryEcomViewPgAdapter.addFragment(new SingleDetailsViewPagerFragment(), "");
        categoryEcomViewPgAdapter.addFragment(new SingleDetailsViewPagerFragment(), "");
        categoryEcomViewPgAdapter.addFragment(new SingleDetailsViewPagerFragment(), "");
        categoryEcomViewPgAdapter.addFragment(new SingleDetailsViewPagerFragment(), "");
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


    @OnClick(R.id.btnBuyNow)
    public void btnBuyNowClicked(View view){
        CartFragment fragment2 = new CartFragment();
        FragmentManager fragmentManager =getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}