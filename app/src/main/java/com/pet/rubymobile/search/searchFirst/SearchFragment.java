package com.pet.rubymobile.search.searchFirst;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.setting.allServices.AllServiceSettingFragment;
import com.pet.rubymobile.setting.allServices.FunctionSettingAdapter;
import com.pet.rubymobile.setting.allServices.PayBillsSettingAdapter;
import com.pet.rubymobile.signup.SignUpActivity;
import com.pet.rubymobile.signup.VerificationOtpActivity;


public class SearchFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FunctionSearcAdapter functionSearchAdapter;
    PayBillsSearchAdapter payBillsSearchAdapter;

    @BindView(R.id.rvAllSrvcFnc)
    RecyclerView rvAllSrvcFnc;
    @BindView(R.id.rvPayBills)
    RecyclerView rvPayBills;


    private Dialog dialog;

    SearchAdapter searchAdapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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

        View view= inflater.inflate(R.layout.fragment_search, container, false);
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
        //for Function Data adapter
        functionSearchAdapter = new FunctionSearcAdapter(getActivity(), SearchFragment.this);
        rvAllSrvcFnc.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvAllSrvcFnc.setAdapter(functionSearchAdapter);

        //for Function Data adapter
        payBillsSearchAdapter = new PayBillsSearchAdapter(getActivity(), SearchFragment.this);
        rvPayBills.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rvPayBills.setAdapter(payBillsSearchAdapter);


       /* searchAdapter = new SearchAdapter(getContext(), SearchFragment.this);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvPayBills.setAdapter(payBillsSearchAdapter);*/

    }

    @OnClick(R.id.ivSearchIcon)
    public void ivSearchIconClicked(View view){
        dialogOpen();
    }


    private void dialogOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialogsearchlist);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        RecyclerView rcSearchList=dialog.findViewById(R.id.rcSearchList);
        SearchAdapter searchAdapter = new SearchAdapter(getActivity(), SearchFragment.this);
        rcSearchList.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        rcSearchList.setAdapter(searchAdapter);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }
}