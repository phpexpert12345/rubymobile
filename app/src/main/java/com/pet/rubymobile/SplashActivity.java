package com.pet.rubymobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.pet.rubymobile.tutorial.tutorial_activity.TutorialActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends Activity {
    @BindView(R.id.ivLogo)
    AppCompatImageView ivLogo;
    @BindView(R.id.pb_loader)
    ProgressBar pbLoader;
    @BindView(R.id.cd_splash)
    RelativeLayout cdSplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.slide_up);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(700);
        ivLogo.startAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), TutorialActivity.class));
                finish();
            }
        }, 1000);
    }
}
