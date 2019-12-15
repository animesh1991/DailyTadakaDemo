package com.animesh.dailytadkarecipes.common.customeviews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class RobotoBoldTextView extends android.support.v7.widget.AppCompatTextView {

    public RobotoBoldTextView(Context context) {
        super(context);
        init(context);
    }

    public RobotoBoldTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RobotoBoldTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
        setTypeface(typeface);
    }

}
