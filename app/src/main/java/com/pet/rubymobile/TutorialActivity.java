package com.pet.rubymobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.pet.rubymobile.adapter.TutorialAdapter;
import com.pet.rubymobile.login.LoginActivity;
import com.pet.rubymobile.model.TutorialModel;
import com.pet.rubymobile.signup.SignUpActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TutorialActivity extends AppCompatActivity {
    @BindView(R.id.vp_tut)
    ViewPager vpTut;
    @BindView(R.id.tl_tut)
    TabLayout tlTut;
    @BindView(R.id.btnRegister)
    AppCompatButton acbTut;
    @BindView(R.id.btnSignIn)
    AppCompatButton materialButtonSkip;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        ButterKnife.bind(this);

        mContext = TutorialActivity.this;

        ArrayList<TutorialModel> mData = new ArrayList<>();
        mData.add(new TutorialModel(R.drawable.all_money, getString(R.string.onboard_one_title), ""));
        mData.add(new TutorialModel(R.drawable.all_money, getString(R.string.onboard_two_title), ""));
        mData.add(new TutorialModel(R.drawable.all_money, getString(R.string.onboard_three_title), ""));

        TutorialAdapter adapter = new TutorialAdapter(this);
        adapter.setList(mData);
        vpTut.setAdapter(adapter);
        tlTut.setupWithViewPager(vpTut, true);

        vpTut.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                if (position == 3) {
                    acbTut.setVisibility(View.VISIBLE);
                    materialButtonSkip.setVisibility(View.INVISIBLE);
                } else {
                    acbTut.setVisibility(View.INVISIBLE);
                    materialButtonSkip.setVisibility(View.VISIBLE);
                }
            }
        });

        vpTut.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
            }
        });
    }

    @OnClick({R.id.btnRegister, R.id.btnSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:
                startActivity(new Intent(TutorialActivity.this, SignUpActivity.class));
                break;
            case R.id.btnSignIn:
                    startActivity(new Intent(TutorialActivity.this, LoginActivity.class));
                break;
        }
    }
}
