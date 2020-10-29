package com.pet.rubymobile.pay_and_scan.payCode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.pet.rubymobile.R;
import com.pet.rubymobile.pay_and_scan.scan_code.ScanCodeFragment;


public class PayCodeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    @BindView(R.id.ivScanCode)
    AppCompatImageView ivScanCode;
    @BindView(R.id.ivMainBarcode)
    AppCompatImageView ivMainBarcode;

    public PayCodeFragment() {

    }


    public static PayCodeFragment newInstance(String param1, String param2) {
        PayCodeFragment fragment = new PayCodeFragment();
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

        View view = inflater.inflate(R.layout.fragment_pay_code, container, false);
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

    }

    @OnClick(R.id.ivScanCode)
    public void ivScanCodeClicked(View view) {
        IntentIntegrator scanIntegrator = new IntentIntegrator(getActivity());
        scanIntegrator.setPrompt("Scan");
        scanIntegrator.setBeepEnabled(true);
        //The following line if you want QR code
        scanIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        // scanIntegrator.setCaptureActivity(PayCodeFragment.class);
        scanIntegrator.setOrientationLocked(true);
        scanIntegrator.setBarcodeImageEnabled(true);

        scanIntegrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanningResult != null) {
            if (scanningResult.getContents() != null) {
                //scanContent = scanningResult.getContents().toString();
                // scanFormat = scanningResult.getFormatName().toString();
            }

            //Toast.makeText(this,"",Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(this,"Nothing scanned",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.ivMainBarcode)
    public void ivMainBarcodeClicked(View view){
        ScanCodeFragment scanCodeFragment=new ScanCodeFragment();
        FragmentManager manager = getParentFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, scanCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.ivPaycode)
    public void ivPaycodeClicked(View view){
        IntentIntegrator scanIntegrator = new IntentIntegrator(getActivity());
        scanIntegrator.setPrompt("Scan");
        scanIntegrator.setBeepEnabled(true);
        //The following line if you want QR code
        scanIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        // scanIntegrator.setCaptureActivity(PayCodeFragment.class);
        scanIntegrator.setOrientationLocked(true);
        scanIntegrator.setBarcodeImageEnabled(true);

        scanIntegrator.initiateScan();
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view){
        getActivity().onBackPressed();
    }
}