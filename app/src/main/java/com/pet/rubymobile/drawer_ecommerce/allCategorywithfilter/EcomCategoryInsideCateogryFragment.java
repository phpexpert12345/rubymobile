package com.pet.rubymobile.drawer_ecommerce.allCategorywithfilter;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.CategoryInsideCategoryEcomAdapater;


public class EcomCategoryInsideCateogryFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CategoryInsideCategoryEcomAdapater categoryDetailsEcomAdapater;
    @BindView(R.id.rvSubCategory)
    RecyclerView rvSubCategory;
    @BindView(R.id.llSort)
    LinearLayout llSort;

    Dialog dialog;

    public EcomCategoryInsideCateogryFragment() {

    }


    public static EcomCategoryInsideCateogryFragment newInstance(String param1, String param2) {
        EcomCategoryInsideCateogryFragment fragment = new EcomCategoryInsideCateogryFragment();
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
        View view = inflater.inflate(R.layout.fragment_ecom_category_inside_cateogry, container, false);
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
        categoryDetailsEcomAdapater = new CategoryInsideCategoryEcomAdapater(getContext(),EcomCategoryInsideCateogryFragment.this);
        rvSubCategory.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvSubCategory.setAdapter(categoryDetailsEcomAdapater);


    }


    @OnClick(R.id.llSort)
    public void llSortClicked(View view) {
        dialogOpen();

    }

    private void dialogOpen() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_filter);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        RecyclerView rvBrand = dialog.findViewById(R.id.rvBrand);
        RecyclerView rvInternalMemory = dialog.findViewById(R.id.rvInternalMemory);
        BrandAdapter categoryThirdAdapater = new BrandAdapter(getContext());
        rvBrand.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvBrand.setAdapter(categoryThirdAdapater);

        BrandAdapter rvInternalMemoryAdapter = new BrandAdapter(getContext());
        rvInternalMemory.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvInternalMemory.setAdapter(rvInternalMemoryAdapter);


        dialog.show();
    }
}