package com.pet.rubymobile.setting.settingNew;

import android.app.Activity;
import android.content.Context;
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

import com.pet.rubymobile.R;
import com.pet.rubymobile.setting.changePassword.ChangePasswordFragment;
import com.suke.widget.SwitchButton;

import java.util.ArrayList;
import java.util.List;


public class SettingFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.sbFastPayment)
    SwitchButton sbFastPayment;
    @BindView(R.id.spAmount)
    AppCompatSpinner spAmount;

    public SettingFragment() {
        // Required empty public constructor
    }


    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
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

        View view = inflater.inflate(R.layout.fragment_setting, container, false);
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
    List<String> spSmileAndList;
    private void viewFinds() {
        spSmileAndList= new ArrayList<String>();
        spSmileAndList.add("UGX 2000");
        spSmileAndList.add("UGX 3000");
        spSmileAndList.add("UGX 4000");
        spSmileAndList.add("UGX 5000");
        spSmileAndList.add("UGX 6000");
        spSmileAndList.add("UGX 7000");
        spSmileAndList.add("UGX 8000");
      /*  ArrayAdapter<String> spSmileAndAdapter = new ArrayAdapter<String>(getContext(), R.layout.simple_spinner, spSmileAndList);
        spSmileAndAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spAmount.setAdapter(spSmileAndAdapter);*/
        CustomAdapter colorAttributeArrayAdapter=new CustomAdapter(getActivity(),R.layout.spinner_dropdown,R.id.tvItemName,spSmileAndList);
        spAmount.setAdapter(colorAttributeArrayAdapter);
    }







    public class CustomAdapter extends ArrayAdapter<String> {

        LayoutInflater flater;

        public CustomAdapter(Activity context,int resouceId, int textviewId, List<String> list){

            super(context,resouceId,textviewId, list);
            flater = context.getLayoutInflater();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {



            View rowview = flater.inflate(R.layout.simple_spinner,null,true);

            AppCompatTextView txtTitle = rowview.findViewById(R.id.tvItemName);
            txtTitle.setText(spSmileAndList.get(position).toString());



            return rowview;
        }
    }


    @OnClick(R.id.btnSignOut)
    public void btnSignOutClicked(View view){
        ChangePasswordFragment fragment2 = new ChangePasswordFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}