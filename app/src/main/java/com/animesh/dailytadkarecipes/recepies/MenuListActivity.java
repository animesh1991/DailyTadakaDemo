package com.animesh.dailytadkarecipes.recepies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.animesh.dailytadkarecipes.R;
import com.animesh.dailytadkarecipes.app.DailyTadka;
import com.animesh.dailytadkarecipes.common.activities.BaseActivity;
import com.animesh.dailytadkarecipes.common.util.Constants;
import com.animesh.dailytadkarecipes.model.RecipeResponse;
import com.animesh.dailytadkarecipes.recepies.adapters.RecipeAdapter;
import com.animesh.dailytadkarecipes.recepies.interactors.RecipeInteractor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindView;

public class MenuListActivity extends BaseActivity implements RecipeInteractor {

    @BindView(R.id.rv_recipe)
    RecyclerView mRvRecipe;

    private int mMenuCode;
    private RecipeAdapter recipeAdapter;
    private List<RecipeResponse> recipeResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {
            mMenuCode = getIntent().getIntExtra(Constants.ExtraBundleKeys.KEY_MENU_TAG, 0);
            Toast.makeText(this, String.valueOf(mMenuCode), Toast.LENGTH_SHORT).show();
        }
        getJson();
    }

    private void getJson() {
        String json;
        json = DailyTadka.getInstance().getFirebaseRemoteConfig().getString(Constants.FireBaseRemoteConfig.VEG_RECIPE_LIST_ENG);
        recipeResponses = new Gson().fromJson(json, new TypeToken<List<RecipeResponse>>() {
        }.getType());
        loadMenu(recipeResponses);
    }

    private void loadMenu(List<RecipeResponse> mRecipeResponseList) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,
                false);
        recipeAdapter = new RecipeAdapter(this, this, mRecipeResponseList);
        mRvRecipe.setLayoutManager(gridLayoutManager);
        mRvRecipe.setAdapter(recipeAdapter);
    }

    @Override
    public int getResId() {
        return R.layout.activity_menu_list;
    }

    @Override
    public void onRecipeClick(int position) {
        RecipeResponse recipeResponse = recipeResponses.get(position);
        Intent recipeDetailIntent = new Intent(this, RecipeDetailActivity.class);
        recipeDetailIntent.putExtra(Constants.ExtraBundleKeys.KEY_RECIPE_DETAILS, recipeResponse);
        startActivity(recipeDetailIntent);
    }
}
