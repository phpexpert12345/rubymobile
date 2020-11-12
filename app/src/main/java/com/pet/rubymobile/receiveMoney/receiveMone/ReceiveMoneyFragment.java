package com.pet.rubymobile.receiveMoney.receiveMone;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.login.LoginActivity;
import com.pet.rubymobile.receiveMoney.receiveMoneyNext.ReceiveMoneyNextFragment;
import com.pet.rubymobile.verification_otp.VerificationOtp;


public class ReceiveMoneyFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Dialog dialog;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.ivScanCode)
    AppCompatButton ivScanCode;

    public ReceiveMoneyFragment() {
        // Required empty public constructor
    }


    public static ReceiveMoneyFragment newInstance(String param1, String param2) {
        ReceiveMoneyFragment fragment = new ReceiveMoneyFragment();
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

        View view= inflater.inflate(R.layout.fragment_receive_money, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.ivScanCode)
    public void ivScanCodeClicked(View view){
        dialogOpen();
    }

    private void dialogOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_amount_get);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Button btn_dialog_next = dialog.findViewById(R.id.btn_dialog_next);

        btn_dialog_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                ReceiveMoneyNextFragment fragment2 = new ReceiveMoneyNextFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view) {
        getActivity().onBackPressed();
    }
}