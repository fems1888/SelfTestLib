package com.example.selftestlib.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @author Created by jackieyao on 2018/2/6.
 */

public class AdUtil {
    /**
     * 将多个对象拼接成字符串
     *
     * @param object
     * @return
     */
    public static String formatString(Object... object) {
        StringBuilder builder = new StringBuilder();
        for (Object o : object) {
            if (o != null) {
                builder.append(o);
            }
        }
        return builder.toString();
    }

    /**
     * String second = "5";
     if (progress<=72){
     second = "5";
     }else if (progress>72&&progress<=144){
     second = "4";
     }else if (progress>144&&progress<=216){
     second = "3";
     }else if (progress>216&&progress<=288){
     second = "2";
     }else if (progress>288&&progress<=360){
     second = "1";
     }
     * 得到当前的秒数 逻辑不完善
     * @param adTime 总的广告时间
     * @param progress 当前的进度
     * @return
     */
    public static int getCurrentSecond(int adTime, float progress) {
        if (adTime<0){
            return 0;
        }
        return (int) Math.floor(((float)(adTime+1)-adTime*progress/360));

    }

    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }

}
