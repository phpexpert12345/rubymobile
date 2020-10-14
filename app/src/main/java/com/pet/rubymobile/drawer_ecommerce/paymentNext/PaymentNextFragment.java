package com.pet.rubymobile.drawer_ecommerce.paymentNext;

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
import com.pet.rubymobile.drawer_ecommerce.payment.PaymentFragment;
import com.pet.rubymobile.drawer_ecommerce.paymentSuccess.PaymentSuccessFragment;
import com.pet.rubymobile.welcome.WelcomeActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaymentNextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaymentNextFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Dialog dialog;

    @BindView(R.id.btnPaySecurely)
    AppCompatButton btnPaySecurely;

    public PaymentNextFragment() {
        // Required empty public constructor
    }


    public static PaymentNextFragment newInstance(String param1, String param2) {
        PaymentNextFragment fragment = new PaymentNextFragment();
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
        View view= inflater.inflate(R.layout.fragment_payment_next, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btnPaySecurely)
    public void btnPaySecurelyClicked(View view){
        dialogOpen();
    }


    private void dialogOpen() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_payment);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        AppCompatButton btnProceed=dialog.findViewById(R.id.btnProceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                dialogOpenForFingerPrint();
            }
        });
        dialog.show();
    }

    private void dialogOpenForFingerPrint() {
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
                dialogOpenForFaceIdForRuby();
            }
        });
        dialog.show();
    }

    private void dialogOpenForFaceIdForRuby() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_faceid);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        AppCompatButton btnFaceId=dialog.findViewById(R.id.btnFaceId);
        btnFaceId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                PaymentSuccessFragment fragment2 = new PaymentSuccessFragment();
                FragmentManager fragmentManager =getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(android.R.id.content, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        dialog.show();
    }

}