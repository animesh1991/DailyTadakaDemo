package com.animesh.dailytadkarecipes.common.util.bindingadapter;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.animesh.dailytadkarecipes.R;
import com.bumptech.glide.Glide;

public class CustomBindingAdapter {

    @BindingAdapter("bindMenuIcons")
    public static void bindMenuIcons(ImageView imageView, String imagePath) {
        if (imagePath != null) {
            Glide.with(imageView.getContext())
                    .load(imagePath)
                    .into(imageView);

        }
    }

    @BindingAdapter("bindMenuColor")
    public static void bindMenuColor(View view, String type) {
        if(!type.equals("")) {
            ((TextView)view).setTextColor(type.equals(view.getContext().getString(R.string.type_veg)) ? ContextCompat.getColor(view.getContext(),R.color.colorDarkGrren) :
                    ContextCompat.getColor(view.getContext(),R.color.colorDarkBrown));
        }
    }


}
