package com.pet.rubymobile.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.pet.rubymobile.R;
import com.pet.rubymobile.welcome.WelcomeActivity;

public class VerificationOtpActivity extends AppCompatActivity {
    @BindView(R.id.pinview)
    PinView pinview;

    @BindView(R.id.btn_next)
    AppCompatButton btn_next;

    @BindView(R.id.view)
    View view;


    @BindView(R.id.tv_changePhoneNumber)
    AppCompatTextView tv_changePhoneNumber;

    @BindView(R.id.tv_send_otp_again)
    AppCompatTextView tv_send_otp_again;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_verification_otp2);
        ButterKnife.bind(this);
        viewFinds();
    }

    private void viewFinds() {
        pinview.addTextChangedListener(new TextWatcher() {
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
                    tv_changePhoneNumber.setTextColor(getResources().getColor(R.color.textForColorGreen));
                    view.setBackgroundColor(getResources().getColor(R.color.textForColorGreen));

                } else {
                    btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login));
                    btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login));


                    tv_changePhoneNumber.setTextColor(getResources().getColor(R.color.untyped_button_color));
                    view.setBackgroundColor(getResources().getColor(R.color.untyped_button_color));
                }
            }
        });


    }

    @OnClick(R.id.btn_next)
    public void btn_nextClicked(View view) {
        startActivity(new Intent(getApplicationContext(),CreatePasswordActivity.class));
    }


    @OnClick(R.id.tv_send_otp_again)
    public void sendOtpAgainClicked(View view){
        sendAgainDialogOpen();
    }

    private void sendAgainDialogOpen() {
        dialog = new Dialog(VerificationOtpActivity.this);
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

        dialog.show();
    }
}