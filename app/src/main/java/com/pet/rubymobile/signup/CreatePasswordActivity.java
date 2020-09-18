package com.pet.rubymobile.signup;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.pet.rubymobile.R;

public class CreatePasswordActivity extends AppCompatActivity {
    @BindView(R.id.btn_enter)
    Button btn_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_create_password);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_enter)
    public void btn_enterClicked(View view){
        startActivity(new Intent(getApplicationContext(),InformationActivity.class));
    }
}