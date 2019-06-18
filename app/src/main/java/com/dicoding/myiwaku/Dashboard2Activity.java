package com.dicoding.myiwaku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransitionImpl;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.dicoding.myiwaku.helper.BottomNavigationBehavior;

import java.util.ArrayList;

public class Dashboard2Activity extends AppCompatActivity {

    private ActionBar toolbar;
    private RecyclerView rvCategory;
    private ArrayList<Shop> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(ShopData.getListData());
        showRecyclerList();
        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // load the store fragment by default
        toolbar.setTitle("Shop");
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListShopAdapter listPresidentAdapter = new ListShopAdapter(this);
        listPresidentAdapter.setListShop(list);
        rvCategory.setAdapter(listPresidentAdapter);
    }
    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GiftShopAdapter giftShopAdapter = new GiftShopAdapter(this);
        giftShopAdapter.setListShop(list);
        rvCategory.setAdapter(giftShopAdapter);
    }

    private void showProfile(){
        Intent myIntent = new Intent(Dashboard2Activity.this, MainActivity.class);
        // myIntent.putExtra("key", value); //Optional parameters
        Dashboard2Activity.this.startActivity(myIntent);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    toolbar.setTitle("Shop");
                    showRecyclerList();
                    return true;
                case R.id.navigation_gifts:
                    toolbar.setTitle("My Gifts");
                    showRecyclerGrid();
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("Cart");
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    showProfile();
                    return true;
            }

            return false;
        }
    };

}