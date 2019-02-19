package com.example2.test.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;



/**
 * Created by carter on 7/19/17.
 */
public class FullScreenVideoView extends VideoView {

    public Context mContext;

    public FullScreenVideoView(Context context) {
        super(context);
        this.mContext = context;
    }

    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(getWidth(), widthMeasureSpec);
        int height = getDefaultSize(getHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

}