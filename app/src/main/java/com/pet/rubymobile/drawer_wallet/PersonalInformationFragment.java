package com.pet.rubymobile.drawer_wallet;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
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
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;


public class PersonalInformationFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Dialog dialog;

    @BindView(R.id.ivEdit)
    AppCompatImageView ivEdit;

    @BindView(R.id.ivBarCode)
    AppCompatImageView ivBarCode;
    @BindView(R.id.rvIdChange)
    RelativeLayout rvIdChange;

    @BindView(R.id.rvDOB)
    RelativeLayout rvDOB;

    @BindView(R.id.rvEmail)
    RelativeLayout rvEmail;

 @BindView(R.id.rlTransactionLimit)
    RelativeLayout rlTransactionLimit;


    public PersonalInformationFragment() {

    }


    public static PersonalInformationFragment newInstance(String param1, String param2) {
        PersonalInformationFragment fragment = new PersonalInformationFragment();
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
        View view = inflater.inflate(R.layout.fragment_personal_information, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.ivEdit)
    public void ivEditClicked(View view) {
        dialogOpen();
    }

    private void dialogOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_personal_information);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    @OnClick(R.id.ivBarCode)
    public void ivBarCodeClicked(View view) {
        MyQrCodeFragment personalInformationFragment = new MyQrCodeFragment();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, personalInformationFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.rvIdChange)
    public void rvIdChangeClicked(View view) {
        ChangeIdFragment personalInformationFragment = new ChangeIdFragment();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, personalInformationFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @OnClick(R.id.rvDOB)
    public void rvDOBClicked(View view) {
        dialogDobOpen();
    }

    private void dialogDobOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_dob_change);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }


    @OnClick(R.id.rvEmail)
    public void rvEmailClicked(View view){
        dialogChangePswdOpen();
    }

    private void dialogChangePswdOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_change_password);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }


    @OnClick(R.id.rlTransactionLimit)
    public void rlTransactionLimitClicked(View view){
        CardBankAccFragment personalInformationFragment = new CardBankAccFragment();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, personalInformationFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view){
        getActivity().onBackPressed();
    }
}