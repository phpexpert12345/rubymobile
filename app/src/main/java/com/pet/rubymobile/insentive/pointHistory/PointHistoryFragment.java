package com.pet.rubymobile.insentive.pointHistory;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pet.rubymobile.R;
import com.pet.rubymobile.home.ui.home.FirstFragment;
import com.pet.rubymobile.insentive.incentives.IncentivesAdapter;
import com.pet.rubymobile.insentive.incentives.IncentivesFragment;
import com.pet.rubymobile.insentive.pointsNext.PointsNextFragment;


public class PointHistoryFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private SecondViewPageAdapter secondViewPageAdapter;



    @BindView(R.id.viewPagerHistory)
    ViewPager viewPagerHistory;

    public PointHistoryFragment() {

    }


    public static PointHistoryFragment newInstance(String param1, String param2) {
        PointHistoryFragment fragment = new PointHistoryFragment();
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

        View view= inflater.inflate(R.layout.fragment_point_history, container, false);
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
       /* receivePointsAdapter = new ReceivePointsAdapter(getContext(), PointHistoryFragment.this);
        rvRPoints.setLayoutManager(new GridLayoutManager(getContext(), 1));
        rvRPoints.setAdapter(receivePointsAdapter);*/

        secondViewPageAdapter = new SecondViewPageAdapter(getFragmentManager());
        secondViewPageAdapter.addFragment(new ReceivePointsFragment(), "one");
        secondViewPageAdapter.addFragment(new UsePointsFragment(), "two");

        viewPagerHistory.setAdapter(secondViewPageAdapter);
        viewPagerHistory.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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