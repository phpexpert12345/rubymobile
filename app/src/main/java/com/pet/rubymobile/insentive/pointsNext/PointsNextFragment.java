package com.pet.rubymobile.insentive.pointsNext;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_paybills.electricity_payment.ElectrircityPayment;
import com.pet.rubymobile.insentive.pointHistory.PointHistoryFragment;


public class PointsNextFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private Dialog dialog;

    public PointsNextFragment() {
        // Required empty public constructor
    }


    public static PointsNextFragment newInstance(String param1, String param2) {
        PointsNextFragment fragment = new PointsNextFragment();
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

        View view= inflater.inflate(R.layout.fragment_points_next, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.rvNext)
    public void rvNextClicked(View view){
        dialogFaceIdOpen();
    }
    private void dialogFaceIdOpen() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_insentive_faceid);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView imageViewIcon = (ImageView) dialog.findViewById(R.id.ivFaceIdWhite);
        imageViewIcon.setColorFilter(getContext().getResources().getColor(R.color.colorWhite));
        RelativeLayout rvCancel=dialog.findViewById(R.id.rvCancel);
        rvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
               dialogFingerOpen();
            }
        });

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    private void dialogFingerOpen() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_insentive_fingerid);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ImageView imageViewIcon = (ImageView) dialog.findViewById(R.id.ivFaceIdWhite);
        imageViewIcon.setColorFilter(getContext().getResources().getColor(R.color.colorWhite));
        RelativeLayout rvCancel=dialog.findViewById(R.id.rvCancel);
        rvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                dialogConfirmOpen();
            }
        });

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }
    private void dialogConfirmOpen() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_insentive_confirm);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        /*ImageView imageViewIcon = (ImageView) dialog.findViewById(R.id.ivFaceIdWhite);
        imageViewIcon.setColorFilter(getContext().getResources().getColor(R.color.colorWhite));*/
        LinearLayout rvCancel=dialog.findViewById(R.id.rvCancel);
        rvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                dialogSuccessOpen();
            }
        });

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }
    private void dialogSuccessOpen() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_insentive_successfull);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        /*ImageView imageViewIcon = (ImageView) dialog.findViewById(R.id.ivFaceIdWhite);
        imageViewIcon.setColorFilter(getContext().getResources().getColor(R.color.colorWhite));*/
        LinearLayout rvCancel=dialog.findViewById(R.id.rvCancel);
        rvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                PointHistoryFragment fragment2 = new PointHistoryFragment();
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
}