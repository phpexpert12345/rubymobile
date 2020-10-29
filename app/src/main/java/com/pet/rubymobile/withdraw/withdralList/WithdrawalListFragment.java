package com.pet.rubymobile.withdraw.withdralList;

import android.app.Dialog;
import android.icu.text.LocaleDisplayNames;
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
import com.pet.rubymobile.deposit.transactionInfoNext.TransactionInfoNextFragment;
import com.pet.rubymobile.withdraw.transactionInformation.TransactionInfoFragment;


public class WithdrawalListFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Dialog dialog;

    @BindView(R.id.btnConfirm)
    AppCompatButton btnConfirm;

    public WithdrawalListFragment() {
        // Required empty public constructor
    }


    public static WithdrawalListFragment newInstance(String param1, String param2) {
        WithdrawalListFragment fragment = new WithdrawalListFragment();
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

        View view= inflater.inflate(R.layout.fragment_withdrawal_list, container, false);
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
        dialogFinerPrintOpen();
    }

       private void dialogFinerPrintOpen() {
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
                dialogFaceIdOpen();
            }
        });

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    private void dialogFaceIdOpen() {
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
                TransactionInfoFragment personalInformationFragment=new TransactionInfoFragment();
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
}