package com.pet.rubymobile.signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.home.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InformationActivity extends AppCompatActivity {

    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;

    @BindView(R.id.etFullName)
    AppCompatEditText etFullName;
    @BindView(R.id.etEmail)
    AppCompatEditText etEmail;
    @BindView(R.id.et_referenceCode)
    AppCompatEditText et_referenceCode;
    @BindView(R.id.btn_next)
    AppCompatButton btn_next;
    @BindView(R.id.relativeLayout_statusBar)
    RelativeLayout relativeLayoutStatusBar;
    @BindView(R.id.view_first)
    View viewFirst;
    @BindView(R.id.view_second)
    View viewSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.bind(this);
        viewFinds();
    }

    private void viewFinds() {
        etFullName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    if (etEmail.getText().length() > 0 && et_referenceCode.getText().length() > 0) {
                        btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                    }


                } else {
                    btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));

                }
            }
        });
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    if (etFullName.getText().length() > 0 && et_referenceCode.getText().length() > 0) {
                        btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                    }


                } else {
                    btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));

                }
            }
        });
        et_referenceCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.length() > 0) {
                    if (etEmail.getText().length() > 0 && etFullName.getText().length() > 0) {
                        btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));
                    }


                } else {
                    btn_next.setBackground(getResources().getDrawable(R.drawable.button_rounded_login_typed));

                }
            }
        });
    }

    @OnClick({R.id.ivBack, R.id.btn_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                onBackPressed();
                break;
            case R.id.btn_next:
                Intent intent = new Intent(InformationActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }
}