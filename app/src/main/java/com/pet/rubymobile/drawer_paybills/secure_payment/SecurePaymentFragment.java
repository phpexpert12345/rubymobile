package com.pet.rubymobile.drawer_paybills.secure_payment;

import android.app.Dialog;
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
import android.widget.LinearLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_paybills.electricity_payment.ElectrircityPayment;
import com.pet.rubymobile.drawer_paybills.electricity_payment_next.ElectricityPaymentNext;
import com.pet.rubymobile.drawer_wallet.BillFragment;

public class SecurePaymentFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.btnConfirm)
    AppCompatButton btnConfirm;

    private Dialog dialog;

    public SecurePaymentFragment() {
        // Required empty public constructor
    }


    public static SecurePaymentFragment newInstance(String param1, String param2) {
        SecurePaymentFragment fragment = new SecurePaymentFragment();
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
        View view= inflater.inflate(R.layout.fragment_secure_payment, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this,view);
        return view;
    }


    @OnClick(R.id.btnConfirm)
    public void btnConfirmClicked(){
        dialogFinerPrintOpen();
    }

    private void dialogFinerPrintOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_finger_print);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        AppCompatButton btn_dialog_next=dialog.findViewById(R.id.btn_dialog_next);
        btn_dialog_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                dialogFaceIdOpen();
            }
        });

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    private void dialogFaceIdOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_faceid);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        AppCompatButton btnFaceId=dialog.findViewById(R.id.btnFaceId);
        btnFaceId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                ElectrircityPayment personalInformationFragment=new ElectrircityPayment();
                FragmentManager manager = getParentFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(android.R.id.content, personalInformationFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view){
        getActivity().onBackPressed();
    }
}