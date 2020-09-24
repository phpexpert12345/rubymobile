package com.pet.rubymobile.home.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.pet.rubymobile.R;

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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // rvCategoryFirst.setLayoutManager(new GridLayoutManager(getContext(), 4));
        //vCategoryFirst.setAdapter(categoryFirstAdapater);


        categoryScndAdapater = new CategoryScndAdapater(getContext());
        rvCategoryScnd.setLayoutManager(new GridLayoutManager(getContext(), 4));
        rvCategoryScnd.setAdapter(categoryScndAdapater);


        categoryThirdAdapater = new CategoryThirdAdapater(getContext());
        rvCategoryThird.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvCategoryThird.setAdapter(categoryThirdAdapater);
        rvCategoryThird.scrollToPosition(3);


        categoryFourthAdapater = new CategoryFourthAdapater(getContext());
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