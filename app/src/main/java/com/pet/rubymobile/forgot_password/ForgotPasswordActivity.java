package com.pet.rubymobile.forgot_password;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;

import com.pet.rubymobile.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends AppCompatActivity {
    @BindView(R.id.btn_sent)
    AppCompatButton btn_sent;

    Dialog dialog;
    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;
    @BindView(R.id.et_passowrd)
    AppCompatEditText etPassowrd;
    @BindView(R.id.et_re_enter_password)
    AppCompatEditText etReEnterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);
        viewFinds();
    }


    @OnClick(R.id.btn_sent)
    public void btn_sentClicked(View view) {

        //startActivity(new Intent(getApplicationContext(), IntroductionsActivity.class));
        dialogOpen();
    }

    private void viewFinds() {
        etReEnterPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    btn_sent.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                } else {
                    btn_sent.setBackground(getResources().getDrawable(R.drawable.button_rounded_login));
                }
            }
        });

        etPassowrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    btn_sent.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                } else {
                    btn_sent.setBackground(getResources().getDrawable(R.drawable.button_rounded_login));
                }
            }
        });
    }

    private void dialogOpen() {
        dialog = new Dialog(ForgotPasswordActivity.this);
        dialog.setContentView(R.layout.dialog_password_reset_sent);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        dialog.getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view) {
        onBackPressed();
    }
}