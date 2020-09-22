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
import com.pet.rubymobile.signup.InformationActivity;
import com.pet.rubymobile.signup.VerificationOtpActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    @BindView(R.id.btn_sent)
    AppCompatButton btn_sent;

    Dialog dialog;

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
    public void btn_sentClicked(View view){

        //startActivity(new Intent(getApplicationContext(), IntroductionsActivity.class));
        dialogOpen();
    }
    private void viewFinds() {
    }


    private void dialogOpen() {
        dialog = new Dialog(ForgotPasswordActivity.this);
        dialog.setContentView(R.layout.dialog_password_reset_sent);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        dialog.show();
    }
}