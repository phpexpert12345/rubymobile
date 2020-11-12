package com.pet.rubymobile.tutorial.tutorial_activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.verification_otp.VerificationOtp;
import com.pet.rubymobile.view.MainActivity;
import com.pet.rubymobile.welcome.WelcomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.tvGetCode)
    AppCompatTextView tvGetCode;
    @BindView(R.id.btnRegister)
    AppCompatButton btnRegister;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mContext = RegisterActivity.this;
    }

    @OnClick({R.id.tvGetCode, R.id.btnRegister, R.id.ivBack})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvGetCode:
                openDialog();
                break;
            case R.id.btnRegister:
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                break;
            case R.id.ivBack:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void openDialog() {
        final Dialog dialog = new Dialog(mContext, R.style.DialogCustomTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sms_call);

        AppCompatTextView tvTitle = dialog.findViewById(R.id.tvTitle);
        AppCompatButton btnCall = dialog.findViewById(R.id.btnCall);
        AppCompatButton btnSms = dialog.findViewById(R.id.btnSms);
        dialog.show();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                openSmsDialog();
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void openSmsDialog() {
        final Dialog dialog = new Dialog(mContext, R.style.DialogCustomTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sms);

        AppCompatButton btnOk = dialog.findViewById(R.id.btnOk);
        dialog.show();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
