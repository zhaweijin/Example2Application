package com.example2.test.floatwindow;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example2.test.base.Example2Application;

public class SmallControlFloatView extends FrameLayout {
    private static final String TAG = "";
    private float mTouchStartX;
    private float mTouchStartY;
    private float x;
    private float y;

    int sW;
    int sH;

    private WindowManager wm=(WindowManager)getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
    private WindowManager.LayoutParams wmParams = ((Example2Application)getContext().getApplicationContext()).getMywmParams();

    public SmallControlFloatView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        sW = wm.getDefaultDisplay().getWidth();
        sH = wm.getDefaultDisplay().getHeight();
        Log.v("aa","sw="+sW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取相对屏幕的坐标，即以屏幕左上角为原点
        x = event.getRawX();
        y = event.getRawY();
        Log.i("aa", "currX"+x+"====currY"+y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //获取相对View的坐标，即以此View左上角为原点
                mTouchStartX =  event.getX();
                mTouchStartY =  event.getY();
                Log.i("aa", "startX"+mTouchStartX+"====startY"+mTouchStartY);
                break;
            case MotionEvent.ACTION_MOVE:
                updateViewPosition();
                break;
            case MotionEvent.ACTION_UP:
                updateViewPosition();
                mTouchStartX=mTouchStartY=0;
                break;
        }
        return true;
    }

    private void updateViewPosition(){
        //更新浮动窗口位置参数
        Log.v("aa","updateViewPosition");
        wmParams.x=(int)( x-mTouchStartX);
        wmParams.y=(int) (y-mTouchStartY);
        Log.v("aa","updateViewPosition = "+wmParams.x);
        if(wmParams.x>sW-getWidth()) wmParams.x = sW-getWidth();
        if(wmParams.x<getWidth()) wmParams.x=0;
        if(wmParams.y<getHeight()) wmParams.y=0;
        if(wmParams.y>sH-getHeight()) wmParams.y = sH-getHeight();

        wm.updateViewLayout(this, wmParams);

    }

}