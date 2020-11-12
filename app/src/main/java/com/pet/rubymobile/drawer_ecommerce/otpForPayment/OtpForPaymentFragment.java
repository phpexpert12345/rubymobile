package com.pet.rubymobile.drawer_ecommerce.otpForPayment;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
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
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.orderDetails.OrderDetailsEcomAdapater;
import com.pet.rubymobile.drawer_ecommerce.orderDetails.OrderDetailsFragment;
import com.pet.rubymobile.drawer_ecommerce.payment.PaymentFragment;
import com.pet.rubymobile.signup.VerificationOtpActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OtpForPaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtpForPaymentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.btnNext)
    AppCompatButton btnNext;
    @BindView(R.id.tvSendOtpAgain)
    AppCompatTextView tvSendOtpAgain;

    Dialog dialog;

    public OtpForPaymentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OtpForPaymentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OtpForPaymentFragment newInstance(String param1, String param2) {
        OtpForPaymentFragment fragment = new OtpForPaymentFragment();
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
        View view = inflater.inflate(R.layout.fragment_otp_for_payment, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnNext)
    public void btnNextClicked(View view) {
        dialogSure();
    }

    @OnClick(R.id.tvSendOtpAgain)
    public void tvSendOtpAgainClicked(View view) {
        sendAgainDialogOpen();
    }


    private void sendAgainDialogOpen() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_signup_send_again);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Button btn_dialog_next = dialog.findViewById(R.id.btn_dialog_next);
        TextView tv_dialog_cancel = dialog.findViewById(R.id.tv_dialog_cancel);
        btn_dialog_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    private void dialogSure() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_sure_transaction);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        AppCompatButton btnSure=dialog.findViewById(R.id.btnSure);
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                OrderDetailsFragment fragment2 = new OrderDetailsFragment();
                FragmentManager fragmentManager =getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view){
        getActivity().onBackPressed();
    }
}