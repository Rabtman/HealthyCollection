package com.rabt.healthycollection.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jaeger.library.StatusBarUtil;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.ui.bwcomic.HealthNewsFragment;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ActionBarDrawerToggle toggle;
    HealthNewsFragment bwComicFragment;

    private int hideFragment = R.id.nav_comic;
    private int showFragment = R.id.nav_comic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        StatusBarUtil.setColorForDrawerLayout(mContext, drawerLayout, ContextCompat.getColor(mContext, R.color.colorPrimary));
        setToolBar(mToolBar, getString(R.string.nav_health));
        toggle = new ActionBarDrawerToggle(this, drawerLayout, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //fragment
        bwComicFragment = new HealthNewsFragment();
        loadMultipleRootFragment(R.id.main_content, 0, bwComicFragment);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_comic:
                        break;
                    case R.id.nav_setting:
                        break;
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressedSupport();
        }
    }

    @Override
    public void showError(String msg) {

    }
}
