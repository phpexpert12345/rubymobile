package com.pet.rubymobile.forgot_password;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.signup.SignUpActivity;
import com.pet.rubymobile.signup.VerificationOtpActivity;

public class IntroductionsActivity extends AppCompatActivity {
    private Dialog dialog;

    @BindView(R.id.btnNext)
    AppCompatButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_introductions);
        ButterKnife.bind(this);
        viewFinds();
    }


    @OnClick(R.id.btnNext)
    public void btnNextClicked(View view){
        startActivity(new Intent(getApplicationContext(),ForgotPasswordActivity.class));
    }
    private void viewFinds() {

    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view){
        onBackPressed();
    }




}