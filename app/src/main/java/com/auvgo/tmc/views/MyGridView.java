package com.auvgo.tmc.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by lc on 2016/11/10
 */
public class MyGridView extends GridView {


    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        int expandSpec = MeasureSpec.makeMeasureSpec(
//                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        int expandSpec = MeasureSpec.makeMeasureSpec(
                2000, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}