简介
====
* 相信大部分app都会有启动页的倒计时view 所以自己做了一个
* 目前只是第一版本，后续会继续完善
* ![](http://g.recordit.co/fnI3LDfymW.gif)

项目链接 [AdCountDownView](https://github.com/fems1888/SelfTestLib)
===
* 如果你感觉到对你有帮助，欢迎star
* 如果你感觉对代码有疑惑，或者需要修改的地方，欢迎issue

主要特性
===
* 样式自定义，拓展性强
* 倒计时时间自己控制
* 文字大小和view的颜色，背景色都可自定义
* 考虑到实际情况 目前只设置了动画结束的回调

使用方法
===
XML布局
--

* 新建XML布局
```Java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.example.jackieyao.testdemo.MainActivity">
    <com.example.selftestlib.AdCountDownView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:Flag="1"
        app:If_Need_Text="true"/>
</LinearLayout>
```
* 自定义View样式
 
  * 代码样式
  ```Java
  adCountDownView.setmStrokeCircleColor(Color.YELLOW);
  adCountDownView.anim();
  ```
  
   * xml样式
   ```Java
   <com.example.selftestlib.AdCountDownView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:Flag="1"
        app:If_Need_Text="true"/>
    ```
 说明
 ======
 * 上面两种样式只是简单的举例，所有的样式都可以在下面的代码里找到
```Java
<declare-styleable name="AdCountDownView">
        <!--控制广告时间-->
        <attr name="AD_Time" format="integer"/>

        <!--是否需要显示文字 eg：是3秒 还是3-->
        <attr name="If_Need_Text" format="boolean"/>

        <!--动画圆的半径-->
        <attr name="Radius" format="dimension"/>

        <!--控制view是有背景还是没有背景 0：无背景  1 ：有背景-->
        <attr name="Flag" format="integer"/>

        <!--倒计时文字的颜色-->
        <attr name="Text_Color" format="color"/>

        <!--倒计时文字的大小-->
        <attr name="Text_Size" format="dimension"/>

        <!--动画圆的颜色-->
        <attr name="StrokeCircleColor" format="color"/>

        <!--背景圆的颜色-->
        <attr name="SolidCircleColor" format="color"/>

        <!--动画圆的描边宽度-->
        <attr name="StrokeWidth" format="dimension"/>

    </declare-styleable>
```
另外可以使用代码来控制中英文或者其他语言
```Java
 adCountDownView.setNeedTextStr("s");
 adCountDownView.setNeedTextStr("秒");
```
动画结束的回调，可以处理动画结束也就是倒计时结束的回调
```java
adCountDownView.setEndCallBack(this);
```

DownLoad
=====
Step 1. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```java
dependencies {
	        compile 'com.github.fems1888:SelfTestLib:1.0.3'
	}
```

   
   





