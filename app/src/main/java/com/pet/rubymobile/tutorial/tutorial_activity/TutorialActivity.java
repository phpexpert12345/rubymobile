package com.pet.rubymobile.tutorial.tutorial_activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.pet.rubymobile.R;
import com.pet.rubymobile.adapter.TutorialAdapter;
import com.pet.rubymobile.login.LoginActivity;
import com.pet.rubymobile.model.TutorialModel;
import com.pet.rubymobile.signup.SignUpActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
    int currentPage = 0, NUM_PAGES;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        ButterKnife.bind(this);

        mContext = TutorialActivity.this;

        ArrayList<TutorialModel> mData = new ArrayList<>();
        mData.add(new TutorialModel(R.drawable.ic_tutorial_one, getString(R.string.onboard_one_title), "Multi storey security unternational standard"));
        mData.add(new TutorialModel(R.drawable.ic_tutorial_two, getString(R.string.onboard_two_title), "Consumer Loan Payment. pay bills and many otper services"));
        mData.add(new TutorialModel(R.drawable.ic_tutorial_three, getString(R.string.onboard_three_title), "Diversify recharge and withdraw money. free recharge with baek account"));
        mData.add(new TutorialModel(R.drawable.ic_tutorial_three, getString(R.string.quick_money), "Send and Recieve Money Quickly just need a phone number"));
        mData.add(new TutorialModel(R.drawable.ic_tutorial_three, getString(R.string.attractive_deal), "High Discount, great promotion"));
        NUM_PAGES = mData.size();
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
               /* if (position == 3) {
                    acbTut.setVisibility(View.VISIBLE);
                    materialButtonSkip.setVisibility(View.INVISIBLE);
                } else {
                    acbTut.setVisibility(View.INVISIBLE);
                    materialButtonSkip.setVisibility(View.VISIBLE);
                }*/
            }
        });

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES ) {
                    currentPage = 0;
                }
                vpTut.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

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
                startActivity(new Intent(TutorialActivity.this, RegisterActivity.class)); //SignUpActivity
                break;
            case R.id.btnSignIn:
                startActivity(new Intent(TutorialActivity.this, LoginActivity.class));
                break;
        }
    }
}
