package com.example.selftestlib;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.selftestlib.util.AdUtil;

/**
 * 广告倒计时view
 * @author Created by jackieyao on 2018/2/6.
 */

public class AdCountDownView extends View implements Animator.AnimatorListener {

    /**
     * 广告时间
     */
    int adTime = 5;

    /**
     * 是否需要中文  秒
     */
    boolean ifNeedTextSec;

    float radius = AdUtil.dpToPixel(40);

    /**
     * 动画的进度
     */
    float progress = 0;
    /**
     * 空心的
     */
    public static int STROKE = 0;
    /**
     * 实心的
     */
    public static int SOLID = 1;

    /**
     * 是空心还是实心的标志
     */
    int flag = 1;
    /**
     * 画笔
     */
    Paint strokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint solidPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int mTextColor = Color.BLACK;

    float mTextSize = AdUtil.dpToPixel(15);

    int mStrokeCircleColor = Color.RED;
    int mSolidCircleColor = Color.GRAY;

    float strokeWidth = AdUtil.dpToPixel(5);

    public AdCountDownView(Context context) {
        this(context,null);
    }

    public AdCountDownView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AdCountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs,R.styleable.AdCountDownView,defStyleAttr,0);

        adTime = ta.getInt(R.styleable.AdCountDownView_AD_Time,5);
        ifNeedTextSec = ta.getBoolean(R.styleable.AdCountDownView_If_Need_Text,false);
        radius = ta.getDimensionPixelSize(R.styleable.AdCountDownView_Radius,80);
        flag = ta.getInt(R.styleable.AdCountDownView_Flag,0);
        mTextColor = ta.getColor(R.styleable.AdCountDownView_Text_Color,Color.BLACK);
        mTextSize = ta.getDimensionPixelSize(R.styleable.AdCountDownView_Text_Size,30);
        mStrokeCircleColor = ta.getColor(R.styleable.AdCountDownView_StrokeCircleColor,Color.RED);
        mSolidCircleColor = ta.getColor(R.styleable.AdCountDownView_SolidCircleColor,Color.GRAY);
        strokeWidth = ta.getDimensionPixelSize(R.styleable.AdCountDownView_StrokeWidth,10);


        ta.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        if (flag == STROKE){
            drawStroke(canvas,centerX,centerY);
        }else if (flag == SOLID){
            solidPaint.setStyle(Paint.Style.FILL);
            solidPaint.setColor(mSolidCircleColor);
            canvas.drawCircle(centerX,centerY,radius - strokeWidth,solidPaint);
            drawStroke(canvas,centerX,centerY);
        }




    }

    private void drawStroke(Canvas canvas, float centerX, float centerY) {
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setColor(mStrokeCircleColor);
        strokePaint.setStrokeCap(Paint.Cap.ROUND);
        strokePaint.setStrokeWidth(strokeWidth);
        canvas.drawArc(centerX - radius,centerY-radius,centerX+radius,centerY+radius,-90+progress,360-progress,false,strokePaint);

        strokePaint.reset();
        strokePaint.setColor(mTextColor);
        strokePaint.setTextSize(mTextSize);
        Log.e("=====",AdUtil.getCurrentSecond(adTime,progress)+"");
        String text = ifNeedTextSec?AdUtil.formatString(AdUtil.getCurrentSecond(adTime,progress),"秒"):AdUtil.formatString(AdUtil.getCurrentSecond(adTime,progress));

        float measureText = strokePaint.measureText(text);

        canvas.drawText(text, centerX-measureText/2, centerY - (strokePaint.ascent() + strokePaint.descent()) / 2, strokePaint);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        anim();
    }

    public void anim(){
        progress = 0;
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 0, 360);
        animator.setDuration(adTime*1000L);
        animator.setInterpolator(new LinearInterpolator());
        animator.addListener(this);
        animator.start();
    }


    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {
        if (endCallBack!=null){
            endCallBack.animEnd();
        }
    }

    @Override
    public void onAnimationCancel(Animator animator) {
    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }

    /**
     * 动画结束的回调 考虑到实际情况 此view大部分情况下只会关注动画结束的处理
     */
    private AnimEndCallBack endCallBack;

    public void setEndCallBack(AnimEndCallBack endCallBack) {
        this.endCallBack = endCallBack;
    }

    public interface AnimEndCallBack{
        void animEnd();
    }
    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        postInvalidate();
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getmTextColor() {
        return mTextColor;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public float getmTextSize() {
        return mTextSize;
    }

    public void setmTextSize(int mTextSize) {
        this.mTextSize = mTextSize;
    }

    public int getmStrokeCircleColor() {
        return mStrokeCircleColor;
    }

    public void setmStrokeCircleColor(int mStrokeCircleColor) {
        this.mStrokeCircleColor = mStrokeCircleColor;
    }

    public int getmSolidCircleColor() {
        return mSolidCircleColor;
    }

    public void setmSolidCircleColor(int mSolidCircleColor) {
        this.mSolidCircleColor = mSolidCircleColor;
    }


    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getAdTime() {
        return adTime;
    }

    public void setAdTime(int adTime) {
        this.adTime = adTime;
    }

    public boolean isIfNeedTextSec() {
        return ifNeedTextSec;
    }

    public void setIfNeedTextSec(boolean ifNeedTextSec) {
        this.ifNeedTextSec = ifNeedTextSec;
    }

}
