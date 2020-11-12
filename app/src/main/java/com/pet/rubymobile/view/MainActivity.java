package com.pet.rubymobile.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.EcomHomeFragment;
import com.pet.rubymobile.drawer_money_transfer.transfer.TransferFragment;
import com.pet.rubymobile.drawer_wallet.PersonalInformationFragment;
import com.pet.rubymobile.home.DrawerAdapater;
import com.pet.rubymobile.home.HomeActivity;
import com.pet.rubymobile.home.ui.home.CategoryFirstAdapater;
import com.pet.rubymobile.home.ui.home.CategoryFourthAdapater;
import com.pet.rubymobile.home.ui.home.CategoryScndAdapater;
import com.pet.rubymobile.home.ui.home.CategoryThirdAdapater;
import com.pet.rubymobile.home.ui.home.FirstFragment;
import com.pet.rubymobile.home.ui.home.FirstViewPageAdapter;
import com.pet.rubymobile.home.ui.home.SecondFragment;
import com.pet.rubymobile.pay_and_scan.payCode.PayCodeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.nikartm.support.ImageBadgeView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.ivNavigation)
    AppCompatImageView ivNavigation;
    @BindView(R.id.ivSearch)
    AppCompatImageView ivSearch;
    @BindView(R.id.ibvNotification)
    ImageBadgeView ibvNotification;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.rvCategoryScnd)
    RecyclerView rvCategoryScnd;
    @BindView(R.id.rvCategoryThird)
    RecyclerView rvCategoryThird;
    @BindView(R.id.rvCategoryFourth)
    RecyclerView rvCategoryFourth;
    @BindView(R.id.tvCashback)
    AppCompatTextView tvCashback;
    @BindView(R.id.tvNsdBusiness)
    AppCompatTextView tvNsdBusiness;
    @BindView(R.id.tvHelpSupport)
    AppCompatTextView tvHelpSupport;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    @BindView(R.id.tvSubHead)
    AppCompatTextView tvSubHead;
    @BindView(R.id.tvFinancialTitle)
    AppCompatTextView tvFinancialTitle;
//    @BindView(R.id.nsv)
//    NestedScrollView nsv;
    @BindView(R.id.rvNavigationDrawer)
    RecyclerView rvNavigationDrawer;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private CategoryScndAdapater categoryScndAdapater;
    private CategoryThirdAdapater categoryThirdAdapater;
    private CategoryFourthAdapater categoryFourthAdapater;
    private CategoryFirstAdapater categoryFirstAdapater;
    private FirstViewPageAdapter firstViewPageAdapter;

    private List<String> secondData;
    private List<String> thirdData;
    private List<String> fourthData;
    private DrawerAdapater drawerAdapater;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = MainActivity.this;

        AppCompatImageView ivClose = navView.findViewById(R.id.ivClose);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        navView.bringToFront();

        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.getMenu().findItem(R.id.action_home).setChecked(true);
        setDrawer();
        setRecyclerView();
        setViewPger();
    }

    private void setDrawer() {
        drawerAdapater = new DrawerAdapater(mContext, drawerLayout);
        rvNavigationDrawer.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvNavigationDrawer.setAdapter(drawerAdapater);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigation.getMenu().findItem(R.id.action_home).setChecked(true);
    }

    private void setViewPger() {
//        categoryFirstAdapater = new CategoryFirstAdapater(mContext);
        firstViewPageAdapter = new FirstViewPageAdapter(getSupportFragmentManager());
        firstViewPageAdapter.addFragment(new FirstFragment(), "");
        firstViewPageAdapter.addFragment(new SecondFragment(), "");

        viewPager.setAdapter(firstViewPageAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setRecyclerView() {
        secondData = new ArrayList();
        secondData.add("Airtime & Data");
        secondData.add("Pay TV");
        secondData.add("Electricity");
        secondData.add("Water");
        secondData.add("School Fees");
        secondData.add("Taxes");
        secondData.add("Cabs");

        categoryScndAdapater = new CategoryScndAdapater(mContext, secondData);
        rvCategoryScnd.setLayoutManager(new GridLayoutManager(mContext, 4) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvCategoryScnd.setAdapter(categoryScndAdapater);

        thirdData = new ArrayList();
        thirdData.add("Insurance");
        thirdData.add("Invest");
        thirdData.add("Instant Loans");

        categoryThirdAdapater = new CategoryThirdAdapater(mContext, thirdData);
        rvCategoryThird.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        rvCategoryThird.setAdapter(categoryThirdAdapater);
        rvCategoryThird.scrollToPosition(3);

        fourthData = new ArrayList();
        fourthData.add("Insurance");
        fourthData.add("Invest");
        fourthData.add("Instant Loans");

        categoryFourthAdapater = new CategoryFourthAdapater(mContext, fourthData);
        rvCategoryFourth.setLayoutManager(new GridLayoutManager(mContext, 4) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvCategoryFourth.setAdapter(categoryFourthAdapater);
    }

    public void llScanAnyQrClicked() {
        PayCodeFragment payCodeFragment = new PayCodeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, payCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void llShopClicked() {
        EcomHomeFragment payCodeFragment = new EcomHomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, payCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void llBankClicked() {
        TransferFragment payCodeFragment = new TransferFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, payCodeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void llProfileClicked() {

//        PersonalInformationFragment payCodeFragment = new PersonalInformationFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(android.R.id.content, payCodeFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
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
                Intent intent1 = new Intent(MainActivity.this, BankActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent1);
                break;
            case R.id.action_home:
//                FragmentManager fm = getSupportFragmentManager();
//                for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
//                    fm.popBackStack();
//                }

                if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
                    getSupportFragmentManager().popBackStack();
                }
//                nsv.fullScroll(NestedScrollView.FOCUS_UP);
                break;
            case R.id.action_profile:
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                break;
            case R.id.action_scan_qr:
                Intent intent3 = new Intent(MainActivity.this, ScanQRActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent3);
                break;
            case R.id.action_shop:
                Intent intent2 = new Intent(MainActivity.this, EcommerceActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
                break;
        }
        return true;
    }

    @OnClick(R.id.ivNavigation)
    public void onClick() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            drawerLayout.openDrawer(Gravity.LEFT);
        }
    }
}
