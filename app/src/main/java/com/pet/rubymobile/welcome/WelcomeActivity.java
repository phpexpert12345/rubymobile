package com.pet.rubymobile.welcome;

import androidx.appcompat.app.AppCompatActivity;
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
import com.pet.rubymobile.login.LoginActivity;
import com.pet.rubymobile.verification_otp.VerificationOtp;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.btn_next)
    Button btn_next;

     @BindView(R.id.tv_signOut)
    TextView tv_signOut;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_next)
    public void btn_nextClicked(View view){
        dialogOpen();
    }

    @OnClick(R.id.tv_signOut)
    public void tv_signOutClicked(View view){
        dialogLogout();
    }


    private void dialogOpen() {
        dialog = new Dialog(WelcomeActivity.this);
        dialog.setContentView(R.layout.dialog_finger_print);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        dialog.show();
    }

    private void dialogLogout() {
        dialog = new Dialog(WelcomeActivity.this);
        dialog.setContentView(R.layout.dialog_logout);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        dialog.show();
    }
}