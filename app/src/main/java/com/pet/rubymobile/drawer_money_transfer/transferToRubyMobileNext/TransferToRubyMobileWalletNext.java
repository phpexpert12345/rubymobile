package com.pet.rubymobile.drawer_money_transfer.transferToRubyMobileNext;

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
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.paymentSuccess.PaymentSuccessFragment;
import com.pet.rubymobile.drawer_money_transfer.withdraw.WithdrawFragment;
import com.pet.rubymobile.welcome.WelcomeActivity;


public class TransferToRubyMobileWalletNext extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.btnConfirm)
    AppCompatButton btnConfirm;

    Dialog dialog;

    public TransferToRubyMobileWalletNext() {
        // Required empty public constructor
    }


    public static TransferToRubyMobileWalletNext newInstance(String param1, String param2) {
        TransferToRubyMobileWalletNext fragment = new TransferToRubyMobileWalletNext();
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

        View view= inflater.inflate(R.layout.fragment_transfer_to_ruby_mobile_wallet_next, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btnConfirm)
    public void btnConfirmClicked(View view){
        dialogOpen();
    }

    private void dialogOpen() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_finger_print);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        AppCompatButton btn_dialog_next=dialog.findViewById(R.id.btn_dialog_next);
        btn_dialog_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                WithdrawFragment paymentSuccessFragment=new WithdrawFragment() ;
                FragmentManager manager = getParentFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(android.R.id.content, paymentSuccessFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        dialog.show();
    }

}