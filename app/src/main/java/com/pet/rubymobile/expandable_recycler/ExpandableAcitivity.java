package com.pet.rubymobile.expandable_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;

import com.pet.rubymobile.R;
import com.pet.rubymobile.home.ui.home.CategoryThirdAdapater;

public class ExpandableAcitivity extends AppCompatActivity {
    /*RecyclerView recycler;
    PeopleAdapter adapter;*/

    @BindView(R.id.rvDrawer)
    RecyclerView rvDrawer;

    DrawerAdapater drawerAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_acitivity);
        ButterKnife.bind(this);


        drawerAdapater = new DrawerAdapater(getApplicationContext());
        rvDrawer.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvDrawer.setAdapter(drawerAdapater);


        /*recycler = (RecyclerView) findViewById(R.id.recycler);
        adapter = new PeopleAdapter(this);
        adapter.setMode(ExpandableRecyclerAdapter.MODE_ACCORDION);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);*/
    }
}