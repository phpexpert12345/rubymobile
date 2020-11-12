package com.pet.rubymobile.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.pet.rubymobile.R;

public class CreatePasswordActivity extends AppCompatActivity {
    @BindView(R.id.btn_enter)
    AppCompatButton btn_enter;
    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;
    @BindView(R.id.et_passowrd)
    AppCompatEditText et_passowrd;
    @BindView(R.id.et_re_enter_password)
    AppCompatEditText et_re_enter_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
        ButterKnife.bind(this);
        viewFinds();
    }

    private void viewFinds() {
        et_re_enter_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    if (et_passowrd.getText().length()>0){
                        btn_enter.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                    }


                } else {
                    btn_enter.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));

                }
            }
        });

        et_passowrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    if (et_re_enter_password.getText().length()>0){
                        btn_enter.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                    }


                } else {
                    btn_enter.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));

                }
            }
        });
    }


    @OnClick(R.id.btn_enter)
    public void btn_enterClicked(View view) {
        startActivity(new Intent(getApplicationContext(), InformationActivity.class));
    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view) {
        onBackPressed();
    }


}