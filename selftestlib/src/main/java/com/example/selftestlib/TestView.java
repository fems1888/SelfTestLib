package com.example.selftestlib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Created by jackieyao on 2018/2/2.
 */

public class TestView extends View {
    private Paint paint;
    public TestView(Context context) {
        this(context,null);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,200,paint);
    }
    public void shiXin(){
        paint.setStyle(Paint.Style.FILL);
        postInvalidate();
    }

    public void kongXin(){
        paint.setStyle(Paint.Style.STROKE);
        postInvalidate();
    }


    public void green(){
        paint.setColor(Color.GREEN);
        postInvalidate();
    }
}
