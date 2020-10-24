package com.pet.rubymobile.home.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.pet.rubymobile.R;
import com.pet.rubymobile.home.ui.home.home.NameAndImagesClass;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {
    @BindView(R.id.rvCategoryScnd)
    RecyclerView rvCategoryScnd;
    @BindView(R.id.rvCategoryThird)
    RecyclerView rvCategoryThird;

    @BindView(R.id.rvCategoryFourth)
    RecyclerView rvCategoryFourth;

    @BindView(R.id.viewPager)
    ViewPager rvCategoryFirst;
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;


    FirstViewPageAdapter firstViewPageAdapter;

    CategoryScndAdapater categoryScndAdapater;
    CategoryThirdAdapater categoryThirdAdapater;
    CategoryFourthAdapater categoryFourthAdapater;
    CategoryFirstAdapater categoryFirstAdapater;

    private HomeViewModel homeViewModel;

    private List secondData;
    private List thirdData;
    private List fourthData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        root.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // rvCategoryFirst.setLayoutManager(new GridLayoutManager(getContext(), 4));
        //vCategoryFirst.setAdapter(categoryFirstAdapater);



        secondData=new ArrayList();
        secondData.add("Airtime & Data");
        secondData.add("Pay TV");
        secondData.add("Electricity");
        secondData.add("Water");
        secondData.add("School Fees");
        secondData.add("Taxes");
        secondData.add("Cabs");
        secondData.add("More");

        categoryScndAdapater = new CategoryScndAdapater(getContext(),secondData);
        rvCategoryScnd.setLayoutManager(new GridLayoutManager(getContext(), 4));
        rvCategoryScnd.setAdapter(categoryScndAdapater);

        thirdData=new ArrayList();
        thirdData.add("Insurance");
        thirdData.add("Invest");
        thirdData.add("Instant Loans");
        thirdData.add("More");

        categoryThirdAdapater = new CategoryThirdAdapater(getContext(),thirdData);
        rvCategoryThird.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvCategoryThird.setAdapter(categoryThirdAdapater);
        rvCategoryThird.scrollToPosition(3);

        fourthData=new ArrayList();
        fourthData.add("Insurance");
        fourthData.add("Invest");
        fourthData.add("Instant Loans");
        fourthData.add("More");
        categoryFourthAdapater = new CategoryFourthAdapater(getContext(),fourthData);
        rvCategoryFourth.setLayoutManager(new GridLayoutManager(getContext(), 4));
        rvCategoryFourth.setAdapter(categoryFourthAdapater);


    }

    @Override
    public void onResume() {
        super.onResume();
        categoryFirstAdapater = new CategoryFirstAdapater(getContext());
        firstViewPageAdapter = new FirstViewPageAdapter(getChildFragmentManager());
        firstViewPageAdapter.addFragment(new FirstFragment(), "");
        firstViewPageAdapter.addFragment(new SecondFragment(), "");
        rvCategoryFirst.setAdapter(firstViewPageAdapter);
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