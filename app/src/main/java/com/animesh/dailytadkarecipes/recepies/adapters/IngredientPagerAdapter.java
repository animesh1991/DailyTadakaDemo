package com.animesh.dailytadkarecipes.recepies.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.animesh.dailytadkarecipes.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class IngredientPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<String> ingredientList;

    public IngredientPagerAdapter(Context mContext, ArrayList<String> ingredientList) {
        this.mContext = mContext;
        this.ingredientList = ingredientList;
    }

    @Override
    public int getCount() {
        return ingredientList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.layout_single_image, container, false);
        ImageView imageView = itemView.findViewById(R.id.iv_ingredients);
        Glide.with(imageView.getContext())
                .load(ingredientList.get(position))
                .into(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);
    }
}
