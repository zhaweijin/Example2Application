package com.example2.test.animal;

/**
 * Created by zwj on 8/21/18.
 */


import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * @author SoBan
 * @create 2017/2/6 10:02.
 * 调用方式： view.startAnimation(AnimationUtils.method(...));
 */
public class HvAnimationUtils {

    /**
     * 渐变的一种效果
     *
     * @param fromAlpha
     * @param toAlpha
     */
    public static Animation setAlphaAnimation(float fromAlpha, float toAlpha) {
        Animation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(500);
        return alphaAnimation;
    }

    /**
     * 定义从屏幕顶部进入的动画效果
     *
     * @param context
     */
    public static Animation inFromTopAnimation() {
        Animation inFromTop = new TranslateAnimation(0.0f, 0.0f, -ScreenUtils.getScreenHeight(), 0.0f);
        inFromTop.setFillAfter(true);
        inFromTop.setDuration(500);
        inFromTop.setRepeatMode(Animation.ZORDER_BOTTOM);
        return inFromTop;
    }

    /**
     * 定义从屏幕顶部退出的动画效果
     *
     * @param context
     */
    public static Animation outToTopAnimation() {
        Animation outToTop = new TranslateAnimation(0.0f, 0.0f, 0.0f, -ScreenUtils.getScreenHeight());
        outToTop.setFillAfter(true);
        outToTop.setDuration(500);
        outToTop.setRepeatMode(Animation.ZORDER_BOTTOM);
        return outToTop;
    }

    /**
     * 定义从屏幕底部进入的动画效果
     *
     * @param context
     */
    public static Animation inFromBottomAnimation() {
        Animation inFromBottom = new TranslateAnimation(0.0f, 0.0f, ScreenUtils.getScreenHeight(), 0.0f);
        inFromBottom.setFillAfter(true);
        inFromBottom.setDuration(500);
        inFromBottom.setRepeatMode(Animation.ZORDER_TOP);
        return inFromBottom;
    }

    /**
     * 定义从屏幕底部退出的动画效果
     *
     * @param context
     */
    public static Animation outToBottomAnimation() {
        Animation outToBottom = new TranslateAnimation(0.0f, 0.0f, 0.0f, ScreenUtils.getScreenHeight());
        outToBottom.setFillAfter(true);
        outToBottom.setDuration(500);
        outToBottom.setRepeatMode(Animation.ZORDER_NORMAL);
        return outToBottom;
    }

    /**
     * 定义从左侧进入的动画效果
     */
    public static Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }


    /**
     * 定义从左侧退出的动画效果
     */
    public static Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(500);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }


    /**
     * 定义从右侧进入的动画效果
     */
    public static Animation inFromRightAnimation() {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(500);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    /**
     * 定义从右侧退出时的动画效果
     */
    public static Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(500);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }
}