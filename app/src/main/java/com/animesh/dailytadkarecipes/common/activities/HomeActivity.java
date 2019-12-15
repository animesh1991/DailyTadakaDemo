package com.animesh.dailytadkarecipes.common.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.common.util.FragmentHelper;
import com.animesh.dailytadkarecipes.recepies.FavouriteFragment;
import com.animesh.dailytadkarecipes.recepies.HomeFragment;
import com.animesh.dailytadkarecipes.recepies.MoreFragment;

import butterknife.BindView;


public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.fl_container)
    ViewGroup flContainer;

    @BindView(R.id.tv_home)
    TextView tvHome;

    @BindView(R.id.tv_favourite)
    TextView tvFavourite;

    @BindView(R.id.tv_more)
    TextView tvMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListeners();
        init();
        callHomeFragment();
    }

    private void init() {
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = HomeActivity.this.getSupportFragmentManager().findFragmentById(R.id.fl_container);
                if (fragment instanceof HomeFragment) {
                    setHomeSelected();
                } else if (fragment instanceof FavouriteFragment) {
                    setFavouriteSelected();
                } else if (fragment instanceof MoreFragment) {
                    setMoreSelected();
                }
            }
        });
    }

    private void setListeners() {
        tvHome.setOnClickListener(this);
        tvFavourite.setOnClickListener(this);
        tvMore.setOnClickListener(this);
    }

    @Override
    public int getResId() {
        return R.layout.activity_home;
    }

    private void callHomeFragment() {
        setHomeSelected();
        FragmentHelper.replaceFragment(R.id.fl_container, HomeFragment.newInstance(), getSupportFragmentManager());
/*
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_container, HomeFragment.newInstance(), "").addToBackStack(null).commit();
*/
    }

    private void setHomeSelected() {
        tvHome.setSelected(true);
        tvFavourite.setSelected(false);
        tvMore.setSelected(false);
    }

    private void setFavouriteSelected() {
        tvHome.setSelected(false);
        tvFavourite.setSelected(true);
        tvMore.setSelected(false);
    }

    private void setMoreSelected() {
        tvHome.setSelected(false);
        tvFavourite.setSelected(false);
        tvMore.setSelected(true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home:
                callHomeFragment();
                break;
            case R.id.tv_favourite:
                callFavouriteFragment();
                break;
            case R.id.tv_more:
                callMoreFragment();
                break;
        }
    }

    private void callMoreFragment() {
        setMoreSelected();
/*
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_container, MoreFragment.newInstance(), "").addToBackStack(null).commit();
*/
        FragmentHelper.replaceFragmentBackStack(R.id.fl_container, MoreFragment.newInstance(), getSupportFragmentManager());

    }

    private void callFavouriteFragment() {
        setFavouriteSelected();
/*
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_container, FavouriteFragment.newInstance(), "").addToBackStack(null).commit();
*/
        FragmentHelper.replaceFragmentBackStack(R.id.fl_container, FavouriteFragment.newInstance(), getSupportFragmentManager());

    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fl_container);
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (currentFragment instanceof HomeFragment) {
            finish();
        } else if (backStackEntryCount > 1) {
            callHomeFragment();
        } else {
            super.onBackPressed();
        }
    }
}
