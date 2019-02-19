package com.example2.test.video;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.VideoView;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;


import com.example2.test.R;

import java.io.IOException;


/**
 * Created by carter on 7/19/17.
 */
public class SurfaceVideoView extends FrameLayout {

    public Context mContext;
    private static final String TAG = "SurfaceVideoView";
    private MediaPlayer mediaPlayer;
    private VideoBody videoBody;

    private SurfaceView sv;
    private SurfaceHolder holder;

    public SurfaceVideoView(Context context,VideoBody videoBody) {
        super(context);
        this.mContext = context;
        this.videoBody = videoBody;
        initView(context);
    }

    public SurfaceVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.mContext = context;
        initView(context);
    }

    public SurfaceVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initView(context);
    }


    private void initView(Context context){
        View.inflate(context, R.layout.video_view_test, this);


    }


    public void startView(){
        sv = (SurfaceView) findViewById(R.id.sv);
        // 为SurfaceHolder添加回调
        sv.getHolder().addCallback(callback);
    }

    public void setWebBody(VideoBody videoBody) {
        this.videoBody = videoBody;

    }

    private Callback callback = new Callback() {
        // SurfaceHolder被修改的时候回调
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            Log.i(TAG, "SurfaceHolder 被销毁");
            // 销毁SurfaceHolder的时候记录当前的播放位置并停止播放
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            Log.i(TAG, "SurfaceHolder 被创建");
            play();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Log.i(TAG, "SurfaceHolder 大小被改变,w="+width+",h="+height);
            //changeVideoSize(width,height);
        }

    };


    /*
     * 停止播放
     */
    public void stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

            //callback.surfaceCreated(sv.getHolder());
        }
    }


    public void changeVideoSize(int surfaceWidth,int surfaceHeight) {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        Log.v(TAG,"W=="+videoHeight+",h=="+videoHeight);

        //根据视频尺寸去计算->视频可以在sufaceView中放大的最大倍数。
        /*float max;
        if (getResources().getConfiguration().orientation== ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            //竖屏模式下按视频宽度计算放大倍数值
            max = Math.max((float) videoWidth / (float) surfaceWidth,(float) videoHeight / (float) surfaceHeight);
        } else{
            //横屏模式下按视频高度计算放大倍数值
            max = Math.max(((float) videoWidth/(float) surfaceHeight),(float) videoHeight/(float) surfaceWidth);
        }

        //视频宽高分别/最大倍数值 计算出放大后的视频尺寸
        videoWidth = (int) Math.ceil((float) videoWidth / max);
        videoHeight = (int) Math.ceil((float) videoHeight / max);*/

        //无法直接设置视频尺寸，将计算出的视频尺寸设置到surfaceView 让视频自动填充。
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(videoWidth, videoHeight);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        sv.setLayoutParams(layoutParams);

    }



    /**
     * 开始播放
     *
     * @param msec 播放初始位置
     */
    protected void play() {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            // 设置播放的视频源
            Log.v(TAG,"UR="+videoBody.getUrl().get(0));
            mediaPlayer.setDataSource(mContext,Uri.parse(videoBody.getUrl().get(0)));
            // 设置显示视频的SurfaceHolder
            mediaPlayer.setDisplay(sv.getHolder());
            Log.i(TAG, "开始装载");
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.i(TAG, "装载完成");
                    mediaPlayer.start();
                }
            });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // 在播放完毕被回调
                    //play();
                }
            });

            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // 发生错误重新播放
                    Log.v(TAG, "Error");
                    return false;
                }
            });

            mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                    Log.v(TAG,"W=="+width+",h=="+height);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                    sv.setLayoutParams(layoutParams);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}