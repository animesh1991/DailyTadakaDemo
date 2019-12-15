package com.animesh.dailytadkarecipes.recepies;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.common.activities.BaseActivity;
import com.animesh.dailytadkarecipes.common.util.Constants;
import com.animesh.dailytadkarecipes.model.RecipeResponse;
import com.animesh.dailytadkarecipes.recepies.adapters.IngredientPagerAdapter;

import butterknife.BindView;
import me.relex.circleindicator.CircleIndicator;

public class RecipeDetailActivity extends BaseActivity {

    @BindView(R.id.vp_ingredients)
    ViewPager vpIngredients;

    @BindView(R.id.vp_circle_indicator)
    CircleIndicator circleIndicator;

    @BindView(R.id.tv_serving_ppl_value)
    TextView tvServingPpl;

    @BindView(R.id.tv_preparation_value)
    TextView tvPreparationTime;

    @BindView(R.id.tv_description_value)
    TextView tvDescription;

    private RecipeResponse recipeResponse = null;
    private Handler handler;
    private boolean shouldAutoViewPager = true;

    final private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (shouldAutoViewPager) {
                if (null != recipeResponse && recipeResponse.getListingImages().size() > 0) {
                    if (vpIngredients.getCurrentItem() == recipeResponse.getListingImages().size() - 1) {
                        vpIngredients.setCurrentItem(0, true);
                    } else {
                        vpIngredients.setCurrentItem(vpIngredients.getCurrentItem() + 1, true);
                    }
                }
                handler.postDelayed(runnable, 3000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {
            recipeResponse = getIntent().getParcelableExtra(Constants.ExtraBundleKeys.KEY_RECIPE_DETAILS);
        }
        init();
        setListeners();
    }

    private void setListeners() {
        vpIngredients.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return !shouldAutoViewPager;
            }
        });
    }

    private void init() {
        vpIngredients.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlack));
        IngredientPagerAdapter ingredientPagerAdapter = new IngredientPagerAdapter(this, recipeResponse.getListingImages());
        vpIngredients.setAdapter(ingredientPagerAdapter);
        vpIngredients.setCurrentItem(0);
        circleIndicator.setViewPager(vpIngredients);
        handler = new Handler();
        handler.postDelayed(runnable, 1000);
        setUIData();
    }

    private void setUIData() {
        tvServingPpl.setText(recipeResponse.getServings());
        tvPreparationTime.setText(recipeResponse.getPreparationTime());
        tvDescription.setText(recipeResponse.getRecipeDescription());
    }

    @Override
    public int getResId() {
        return R.layout.activity_recipe_detail;
    }


}
