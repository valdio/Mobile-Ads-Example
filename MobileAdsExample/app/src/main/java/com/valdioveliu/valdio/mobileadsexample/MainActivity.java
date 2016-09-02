package com.valdioveliu.valdio.mobileadsexample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    //private AdView adView;
    //private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_send);

        setupNavigationDrawer();



    }
//
//    private void initRecyclerView() {
//        //Create dummy data for RecyclerView
//        int listSize = 50;
//        int ITEM = 0;
//        int NATIVE_AD = 1;
//        List<Data> data = new ArrayList<>();
//        int[] viewTypes = new int[listSize];
//        for (int i = 0; i < listSize; i++) {
//            data.add(new Data());
//            //insert native ads once in five items
//            if (i > 1 && i % 5 == 0) {
//                viewTypes[i] = NATIVE_AD;
//            } else {
//                viewTypes[i] = ITEM;
//            }
//        }
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        RV_Adapter adapter = new RV_Adapter(data, viewTypes);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }


    // Initialize NavigationView
    private void setupNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.container_view);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Hide helping TextViews
                findViewById(R.id.helpText1).setVisibility(View.GONE);
                findViewById(R.id.helpText2).setVisibility(View.GONE);


                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                int checkedID = menuItem.getItemId();
                switch (checkedID) {
                    case R.id.nav_banner:
                        Fragment bannerFragment = new BannerFragment();
                        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.add(R.id.container_view, bannerFragment, "banner");
                        transaction.commit();
                        break;
                    case R.id.nav_interstitial:
                        Fragment interstitialFragment = new InterstitialFragment();
                        android.support.v4.app.FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                        transaction1.add(R.id.container_view, interstitialFragment, "interstitial");
                        transaction1.commit();
                        break;
                    case R.id.nav_native:
                        Fragment nativeFragment = new NativeFragment();
                        android.support.v4.app.FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                        transaction2.add(R.id.container_view, nativeFragment, "native");
                        transaction2.commit();
                        break;
                }
                return true;
            }
        });
    }

//
//    private void loadInterstitialAd() {
//        interstitialAd = new InterstitialAd(this);
//        interstitialAd.setAdUnitId(getResources().getString(R.string.admob_interstitial_ad));
//        AdRequest adRequest = new AdRequest.Builder()
//                .build();
//        interstitialAd.loadAd(adRequest);
//        interstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                interstitialAd.show();
//            }
//        });
//    }

}
