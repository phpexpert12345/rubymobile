package com.pet.rubymobile.home;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.EcomHomeFragment;
import com.pet.rubymobile.drawer_money_transfer.transfer.TransferFragment;
import com.pet.rubymobile.drawer_wallet.PersonalInformationFragment;
import com.pet.rubymobile.home.ui.home.HomeFragment;
import com.pet.rubymobile.pay_and_scan.payCode.PayCodeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private AppBarConfiguration mAppBarConfiguration;

    @BindView(R.id.ivNavigation)
    AppCompatImageView ivNavigation;

    @BindView(R.id.rvNavigationDrawer)
    RecyclerView rvNavigationDrawer;
    @BindView(R.id.llScanAnyQr)
    LinearLayout llScanAnyQr;
    @BindView(R.id.ivSanCode)
    AppCompatImageView ivSanCode;
    @BindView(R.id.ivShop)
    AppCompatImageView ivShop;
    @BindView(R.id.ivBank)
    AppCompatImageView ivBank;
    @BindView(R.id.ivMe)
    AppCompatImageView ivMe;

    DrawerLayout drawer;
    DrawerAdapater drawerAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        viewFinds();

        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.getMenu().findItem(R.id.action_home).setChecked(true);
    }

    private void viewFinds() {
        //for white bottom navigation images programatically
        ivSanCode.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorWhite));
        ivShop.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorWhite));
        ivBank.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorWhite));
        ivMe.setColorFilter(getApplicationContext().getResources().getColor(R.color.colorWhite));


//        drawerAdapater = new DrawerAdapater(getApplicationContext(), HomeActivity.this);
//        rvNavigationDrawer.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
//        rvNavigationDrawer.setAdapter(drawerAdapater);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @OnClick(R.id.ivNavigation)
    public void ivNavigationClicked(View view) {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(Gravity.LEFT);
        } else {
            drawer.openDrawer(Gravity.LEFT);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void callFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.home_frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        drawer.closeDrawer(Gravity.LEFT);
    }

    public void callFragmentTopInvisible(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.homeFrameTopInvisble, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        drawer.closeDrawer(Gravity.LEFT);
    }

    public void callFragmentFullScreen(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        drawer.closeDrawer(Gravity.LEFT);
    }

    @OnClick(R.id.llScanAnyQr)
    public void llScanAnyQrClicked() {
        PayCodeFragment payCodeFragment = new PayCodeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, payCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.llShop)
    public void llShopClicked() {
        EcomHomeFragment payCodeFragment = new EcomHomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, payCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.llBank)
    public void llBankClicked() {
        TransferFragment payCodeFragment = new TransferFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, payCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @OnClick(R.id.llProfile)
    public void llProfileClicked() {
        PersonalInformationFragment payCodeFragment = new PersonalInformationFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, payCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // uncheck the other items.
//        mMenuId = item.getItemId();
        for (int i = 0; i < bottomNavigation.getMenu().size(); i++) {
            MenuItem menuItem = bottomNavigation.getMenu().getItem(i);
            boolean isChecked = menuItem.getItemId() == item.getItemId();
            menuItem.setChecked(isChecked);
        }

        switch (item.getItemId()) {
            case R.id.action_bank:
                llBankClicked();
                break;
            case R.id.action_home:
                FragmentManager fm = getSupportFragmentManager();
                for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                    fm.popBackStack();
                }
//                HomeFragment fragment = new HomeFragment();
//                callFragment(fragment);
                break;
            case R.id.action_profile:
                llProfileClicked();
                break;
            case R.id.action_scan_qr:
                llScanAnyQrClicked();
                break;
            case R.id.action_shop:
                llShopClicked();
                break;
        }
        return true;
    }
}