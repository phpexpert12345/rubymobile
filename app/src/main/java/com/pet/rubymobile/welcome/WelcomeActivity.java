package com.pet.rubymobile.welcome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.pet.rubymobile.R;
import com.pet.rubymobile.expandable_recycler.ExpandableAcitivity;
import com.pet.rubymobile.forgot_password.IntroductionsActivity;
import com.pet.rubymobile.home.HomeActivity;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.btn_next)
    AppCompatButton btn_next;

    @BindView(R.id.tv_signOut)
    AppCompatTextView tv_signOut;
    @BindView(R.id.tvForgotPassword)
    AppCompatTextView tvForgotPassword;

    @BindView(R.id.ivFingerPrint)
    AppCompatImageView ivFingerPrint;
    @BindView(R.id.ivFaceId)
    AppCompatImageView ivFaceId;

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
    public void btn_nextClicked(View view) {
        dialogOpen();
    }

    @OnClick(R.id.tv_signOut)
    public void tv_signOutClicked(View view) {
        dialogLogout();
    }

    @OnClick(R.id.tvForgotPassword)
    public void tvForgotPasswordClicked(View view) {
        startActivity(new Intent(getApplicationContext(), IntroductionsActivity.class));
    }

    @OnClick(R.id.ivFingerPrint)
    public void fingerPrintLogin(View view) {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }

    @OnClick(R.id.ivFaceId)
    public void ivFaceIdClicked(View view){
        startActivity(new Intent(getApplicationContext(), ExpandableAcitivity.class));
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