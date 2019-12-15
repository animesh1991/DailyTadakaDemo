package com.animesh.dailytadkarecipes.common.customeviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class RobotoRegularTextView extends android.support.v7.widget.AppCompatTextView {

    public RobotoRegularTextView(Context context) {
        super(context);
        init(context);
    }

    public RobotoRegularTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RobotoRegularTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        setTypeface(typeface);
    }

}
