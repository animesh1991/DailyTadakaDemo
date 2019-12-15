package com.animesh.dailytadkarecipes.common.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.app.DailyTadka;
import com.animesh.dailytadkarecipes.common.util.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_splash_logo)
    ImageView ivSplashLogo;

    private boolean imageLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadSplashImage();
//        loadSplash();
    }

    private void loadSplashImage() {
        Glide.with(this)
                .load(DailyTadka.getInstance().getFirebaseRemoteConfig().getString(Constants.FireBaseRemoteConfig.REMOTE_SPLASH_SCREEN))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Toast.makeText(getApplicationContext(), "SomeThing went wrong", Toast.LENGTH_SHORT).show();
                        loadSplash();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        loadSplash();
                        return false;
                    }
                })
                .into(ivSplashLogo);
    }

    @Override
    public int getResId() {
        return R.layout.activity_splash;
    }

    private void loadSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }, 2000);
    }
}
