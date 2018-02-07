package com.example.jackieyao.selftestlib;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.selftestlib.AdCountDownView;

public class MainActivity extends AppCompatActivity implements AdCountDownView.AnimEndCallBack {
    AdCountDownView adCountDownView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        adCountDownView = findViewById(R.id.ad);
        adCountDownView.setEndCallBack(this);
        adCountDownView.setNeedTextStr("s");
//        adCountDownView.setNeedTextStr("秒");
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
