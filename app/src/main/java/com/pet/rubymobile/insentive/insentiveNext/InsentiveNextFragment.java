package com.pet.rubymobile.insentive.insentiveNext;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.insentive.points.PointsFragment;
import com.pet.rubymobile.setting.settingNew.SettingFragment;

import java.util.ArrayList;
import java.util.List;


public class InsentiveNextFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.spCategory)
    AppCompatSpinner spCategory;

    @BindView(R.id.spSort)
    AppCompatSpinner spSort;

    public InsentiveNextFragment() {
        // Required empty public constructor
    }


    public static InsentiveNextFragment newInstance(String param1, String param2) {
        InsentiveNextFragment fragment = new InsentiveNextFragment();
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
        View view = inflater.inflate(R.layout.fragment_insentive_next, container, false);
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
        List<String> categories = new ArrayList<String>();
        categories.add("Shopping");
        categories.add("Restaurant");
        categories.add("Coffee/Desert");
        categories.add("Entertainment");
        categories.add("Super Market");
        categories.add("See More...");
        CustomCategoryAdapter colorAttributeArrayAdapter1=new CustomCategoryAdapter(getActivity(),R.layout.spinner_dropdown,R.id.tvItemName,categories);
        spCategory.setAdapter(colorAttributeArrayAdapter1);


        List<String> sort = new ArrayList<String>();
        sort.add("All");
        sort.add("Most Popular");
        sort.add("Latest");
        sort.add("Lowest Points");
        sort.add("Highest Point");
        sort.add("Closest to me");
        CustomCategoryAdapter colorAttributeArrayAdapter=new CustomCategoryAdapter(getActivity(),R.layout.spinner_dropdown,R.id.tvItemName,sort);
        spSort.setAdapter(colorAttributeArrayAdapter);
    }

    public class CustomCategoryAdapter extends ArrayAdapter<String> {

        LayoutInflater flater;
        List<String> list;

        public CustomCategoryAdapter(Activity context, int resouceId, int textviewId, List<String> list){

            super(context,resouceId,textviewId, list);
            flater = context.getLayoutInflater();
            this.list=list;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {



            View rowview = flater.inflate(R.layout.simple_spinner,null,true);

            AppCompatTextView txtTitle = rowview.findViewById(R.id.tvItemName);
            txtTitle.setText(list.get(position).toString());



            return rowview;
        }
    }

    @OnClick(R.id.cvFirst)
    public void ivFirstClicked(View view){
        PointsFragment fragment2 = new PointsFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}