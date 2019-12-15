package com.animesh.dailytadkarecipes.common.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.databinding.ActivityBaseBinding;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityBaseBinding activityBaseBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        DataBindingUtil.inflate(getLayoutInflater(), getResId(), activityBaseBinding.flContainerMain, true);
        ButterKnife.bind(this);
    }

    public abstract int getResId();

    public void showToolBar(String title) {
        activityBaseBinding.toolbar.setVisibility(View.VISIBLE);
        activityBaseBinding.toolbar.setTitle(title);
    }


}
