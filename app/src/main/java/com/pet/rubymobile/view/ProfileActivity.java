package com.pet.rubymobile.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_wallet.CardBankAccFragment;
import com.pet.rubymobile.drawer_wallet.ChangeIdFragment;
import com.pet.rubymobile.drawer_wallet.MyQrCodeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;
    @BindView(R.id.relativeLayout_statusBar)
    RelativeLayout relativeLayoutStatusBar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.ivEdit)
    AppCompatImageView ivEdit;
    @BindView(R.id.cvImage)
    CardView cvImage;
    @BindView(R.id.tvName)
    AppCompatTextView tvName;
    @BindView(R.id.ivBarCode)
    AppCompatImageView ivBarCode;
    @BindView(R.id.rvIdChange)
    RelativeLayout rvIdChange;
    @BindView(R.id.rvDOB)
    RelativeLayout rvDOB;
    @BindView(R.id.rvEmail)
    RelativeLayout rvEmail;
    @BindView(R.id.rlTransactionLimit)
    RelativeLayout rlTransactionLimit;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        mContext = ProfileActivity.this;

        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.getMenu().findItem(R.id.action_profile).setChecked(true);
    }

    @OnClick(R.id.ivEdit)
    public void ivEditClicked(View view) {
        dialogOpen();
    }

    private void dialogOpen() {
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_personal_information);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }

    @OnClick(R.id.ivBarCode)
    public void ivBarCodeClicked(View view) {
        Fragment personalInformationFragment = new MyQrCodeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, personalInformationFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.rvIdChange)
    public void rvIdChangeClicked(View view) {
        Fragment personalInformationFragment = new ChangeIdFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, personalInformationFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @OnClick(R.id.rvDOB)
    public void rvDOBClicked(View view) {
        dialogDobOpen();
    }

    private void dialogDobOpen() {
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_dob_change);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }


    @OnClick(R.id.rvEmail)
    public void rvEmailClicked(View view) {
        dialogChangePswdOpen();
    }

    private void dialogChangePswdOpen() {
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.dialog_change_password);
        Window window = dialog.getWindow();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
    }


    @OnClick(R.id.rlTransactionLimit)
    public void rlTransactionLimitClicked(View view) {
        Fragment personalInformationFragment = new CardBankAccFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, personalInformationFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @OnClick(R.id.ivBack)
    public void ivBackClicked(View view) {
        onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        for (int i = 0; i < bottomNavigation.getMenu().size(); i++) {
            MenuItem menuItem = bottomNavigation.getMenu().getItem(i);
            boolean isChecked = menuItem.getItemId() == item.getItemId();
            menuItem.setChecked(isChecked);
        }

        switch (item.getItemId()) {
            case R.id.action_bank:
                Intent intent1 = new Intent(mContext, BankActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent1);
                break;
            case R.id.action_home:
                Intent intent4 = new Intent(mContext, MainActivity.class);
                intent4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent4);
                break;
            case R.id.action_profile:
                Intent intent = new Intent(mContext, ProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                break;
            case R.id.action_scan_qr:
                Intent intent3 = new Intent(mContext, ScanQRActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent3);
                break;
            case R.id.action_shop:
                Intent intent2 = new Intent(mContext, EcommerceActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
                break;
        }
        return true;
    }
}
