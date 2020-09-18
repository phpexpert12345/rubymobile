package com.pet.rubymobile.verification_otp;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import okhttp3.CertificatePinner;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

import com.pet.rubymobile.R;
import com.pet.rubymobile.welcome.WelcomeActivity;

public class VerificationOtp extends AppCompatActivity {
    @BindView(R.id.pinview)
    PinView pinview;

    @BindView(R.id.btn_next)
    Button btn_next;

 @BindView(R.id.view)
 View view;


 @BindView(R.id.tv_changePhoneNumber)
 TextView tv_changePhoneNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_verification_otp);
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
                    tv_changePhoneNumber.setTextColor(getResources().getColor(R.color.colorPrimary));
                    view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

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
    public void btn_nextClicked(View view){
        Intent intent=new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(intent);
    }


}