package com.pet.rubymobile.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pet.rubymobile.R;
import com.pet.rubymobile.drawer_ecommerce.CategoryEcomAdapater;
import com.pet.rubymobile.drawer_ecommerce.EcomCatDetailsFragment;
import com.pet.rubymobile.drawer_ecommerce.EcomHomeFragment;
import com.pet.rubymobile.interfaces.ItemClickViewPositionListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EcommerceActivity extends AppCompatActivity implements ItemClickViewPositionListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.rvCategoryScnd)
    RecyclerView rvCategoryScnd;
    @BindView(R.id.ivBack)
    AppCompatImageView ivBack;
    @BindView(R.id.relativeLayout_statusBar)
    RelativeLayout relativeLayoutStatusBar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    CategoryEcomAdapater categoryScndAdapater;
    private List itemName;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce);
        ButterKnife.bind(this);
        mContext = EcommerceActivity.this;
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.getMenu().findItem(R.id.action_shop).setChecked(true);
        additem();
    }

    private void additem() {
        itemName = new ArrayList();
        itemName.add("Beauty");
        itemName.add("Mobile Phone");
        itemName.add("Men's Fashion");
        itemName.add("Grocery");
        itemName.add("Buy Electronics");
        itemName.add("Women's Fashion");
        itemName.add("Sport Shoes");
        itemName.add("Kitchen");
        itemName.add("Beauty");
        itemName.add("Mobile Phone");
        itemName.add("Men's Fashion");
        itemName.add("Grocery");
        itemName.add("Buy Electronics");
        itemName.add("Women's Fashion");
        itemName.add("Sport Shoes");
        itemName.add("Kitchen");
        itemName.add("Kitchen");
        itemName.add("Beauty");
        itemName.add("Mobile Phone");
        itemName.add("Men's Fashion");
        categoryScndAdapater = new CategoryEcomAdapater(mContext, itemName);
        rvCategoryScnd.setLayoutManager(new GridLayoutManager(mContext, 3));
        rvCategoryScnd.setAdapter(categoryScndAdapater);
        categoryScndAdapater.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Fragment fragment2 = new EcomCatDetailsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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
