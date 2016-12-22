package com.rabt.healthycollection.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.jaeger.library.StatusBarUtil;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.ui.drug.DrugMainFragment;
import com.rabt.healthycollection.ui.health.HealthNewsMainFragment;
import com.rabt.healthycollection.ui.hospital.HospitalMainFragment;
import com.rabt.healthycollection.ui.hospital.HospitalSearchResultActivity;
import com.rabt.healthycollection.utils.StringUtils;
import com.rabt.healthycollection.utils.ToastUtil;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

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
    HealthNewsMainFragment healthNewsMainFragment;
    HospitalMainFragment hospitalMainFragment;
    DrugMainFragment drugMainFragment;

    private int hideFragment = R.id.nav_health;
    private int showFragment = R.id.nav_health;

    private MenuItem searchView;

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
    protected void setStatusBar() {
        StatusBarUtil.setColorForDrawerLayout(mContext, drawerLayout, ContextCompat.getColor(mContext, R.color.colorPrimary), 0);
    }

    @Override
    protected void initData() {
        setToolBar(mToolBar, getString(R.string.nav_health));
        toggle = new ActionBarDrawerToggle(this, drawerLayout, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //fragment
        healthNewsMainFragment = new HealthNewsMainFragment();
        hospitalMainFragment = new HospitalMainFragment();
        drugMainFragment = new DrugMainFragment();
        loadMultipleRootFragment(R.id.main_content, 0, healthNewsMainFragment, hospitalMainFragment, drugMainFragment);
        navigationView.getMenu().findItem(R.id.nav_health).setChecked(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_health:
                        showFragment = R.id.nav_health;
                        searchView.setVisible(false);
                        break;
                    case R.id.nav_hospital:
                        showFragment = R.id.nav_hospital;
                        searchView.setVisible(true);
                        break;
                    case R.id.nav_drug:
                        showFragment = R.id.nav_drug;
                        searchView.setVisible(false);
                        break;
                    case R.id.nav_setting:
                        showFragment = R.id.nav_setting;
                        searchView.setVisible(false);
                        break;
                }
                showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                mToolBar.setTitle(item.getTitle());
                hideFragment = showFragment;
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private SupportFragment getTargetFragment(int tag) {
        switch (tag) {
            case R.id.nav_health:
                return healthNewsMainFragment;
            case R.id.nav_hospital:
                return hospitalMainFragment;
            case R.id.nav_drug:
                return drugMainFragment;
            case R.id.nav_setting:
                return healthNewsMainFragment;
        }
        return healthNewsMainFragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        searchView = menu.findItem(R.id.search_view);
        SearchView view = (SearchView) searchView.getActionView();
        view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (StringUtils.isEmpty(query)) {
                    ToastUtil.shortShow(getString(R.string.msg_search_keyword_null));
                } else {
                    //KeyboardUtils.hideSoftInput(this);
                    Intent intent = new Intent(getBaseContext(), HospitalSearchResultActivity.class);
                    intent.putExtra(HealthConstants.HOSPITAL_KEYWORD, query);
                    startActivity(intent);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
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
