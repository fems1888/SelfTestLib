package com.example.jackieyao.selftestlib;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.selftestlib.AdCountDownView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdCountDownView.AnimEndCallBack {
    AdCountDownView adCountDownView;
    private String startTime = "2018-02-08 15:02:00";
    private String endTime = "2018-02-14 15:02:00";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        adCountDownView = findViewById(R.id.ad);
        adCountDownView.setEndCallBack(this);
        adCountDownView.setNeedTextStr("s");
//        adCountDownView.setNeedTextStr("秒");



        test();
    }

    private void test() {

        Log.e("*******",byTimeGetSingle("2018-02-08")+"");
        Log.e("*******==",byTimeGetSingle("2018-2-8")+"");
         long start = byTimeGetSingle(startTime.split(" ")[0]);
         long end = byTimeGetSingle(endTime.split(" ")[0]);
         long day = (24L*60*60*1000L);
         for (long i = start;i<=end;i=i+day){
             Log.e("&&&&",byMillsecondsToSingleFormat(i));
         }

    }
    public static long byTimeGetSingle(String time){
        //Date或者String转化为时间戳
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            return System.currentTimeMillis();
        }
        return date.getTime();
    }

    public static String byMillsecondsToSingleFormat(long millseconds) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-M-d");
        Date d = new Date(millseconds);
        return sf.format(d);
    }

    public void stroke(View view){
        adCountDownView.setFlag(AdCountDownView.STROKE);
        adCountDownView.anim();

    }

    public void solid(View view){
        adCountDownView.setFlag(AdCountDownView.SOLID);
        adCountDownView.anim();
    }
    public void strokeCircleColor(View view){
        adCountDownView.setmStrokeCircleColor(Color.RED);
        adCountDownView.anim();
    }
    public void textSize(View view){
        adCountDownView.setmTextSize(50);
        adCountDownView.anim();
    }
    public void radius(View view){
        adCountDownView.setRadius(50);
        adCountDownView.setStrokeWidth(5);
        adCountDownView.anim();
    }
    public void sec(View view){
        adCountDownView.setIfNeedTextSec(true);
        adCountDownView.anim();
    }
    public void color(View view){
        adCountDownView.setmTextColor(Color.RED);
        adCountDownView.anim();
    }
    public void gap(View view){
        adCountDownView.setHasGap(false);
        adCountDownView.anim();
    }

    @Override
    public void animEnd() {
        Toast.makeText(getApplicationContext(),"动画结束",Toast.LENGTH_LONG).show();
    }
}
