package com.pet.rubymobile.login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.verification_otp.VerificationOtp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.et_mobileNumber)
    EditText et_mobileNumber;
    @BindView(R.id.btn_next)
    Button btn_next;

    Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        viewFinds();
    }

    private void viewFinds() {
        et_mobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                } else {
                    btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login));
                }
            }
        });
    }

    @OnClick(R.id.btn_next)
    public void buttonNextClicked(View view) {
        dialogOpen();
    }


    private void dialogOpen() {
        dialog = new Dialog(LoginActivity.this);
        dialog.setContentView(R.layout.dialog_login);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        Button btn_dialog_next = dialog.findViewById(R.id.btn_dialog_next);
        TextView tv_dialog_cancel = dialog.findViewById(R.id.tv_dialog_cancel);
        btn_dialog_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent verificationOTP=new Intent(getApplicationContext(), VerificationOtp.class);
             startActivity(verificationOTP);
            }
        });
        tv_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dialog.cancel();
            }
        });

        dialog.show();
    }
}
