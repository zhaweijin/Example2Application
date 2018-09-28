package com.example2.test.animal;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example2.test.R;
import com.example2.test.base.BaseActivity;

/**
 * Created by zwj on 8/20/18.
 */

public class AnimationTest extends BaseActivity{

    /**
     *
     * 常见的属性值：translationX、translationY：view对象从他布局容器的左上角坐标偏移的位置
     　　　　　　　 rotation、rotationX、rotationY：控制view围绕支点进行2D、3D的旋转
     　　　　　　　 scaleX、scaleY：控制view对象围绕支点进行2D缩放
     　　　　　　　 pivotX、pivotY：view对象的支点位置，围绕这个支点旋转缩放，默认为view对象的中心店
     　　　　　　　 x、y：view在容器中的位置
     　　　　　　　 alpha：view的透明度
     *
     *
     *
     *
     *  ValueAnimator在属性动画中占非常重要的地位。他本身不提供任何动画效果
     *  因此实际有效果动画的是ObjectAnimator
     *
     */

    private Button button;
    private Button button2;
    private Button button3;
    private ImageView frameImageView;
    private String TAG = "animal";

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, AnimationTest.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animation_test);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                propertyHolderTest(v);
//                animatorSetTest(v);
                singleAnimatorTest(v);
            }
        });


        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"button2");
                Animation animation2 = AnimationUtils.loadAnimation(AnimationTest.this, R.anim.disappear);
                animation2.setFillAfter(true);
                button2.startAnimation(animation2);
            }
        });


        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"button2");
                button2.startAnimation(AnimationUtils.loadAnimation(AnimationTest.this, R.anim.disappear));
            }
        });


        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"button3");
                button3.startAnimation(HvAnimationUtils.inFromTopAnimation());
            }
        });


        frameImageView = (ImageView)findViewById(R.id.image);
        frameImageView.setImageResource(R.drawable.frameanimation);
        AnimationDrawable animationDrawable = (AnimationDrawable) frameImageView.getDrawable();
        animationDrawable.start();
    }




    private void propertyHolderTest(View view){
        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("translationX",0, 500);
        ObjectAnimator.ofPropertyValuesHolder(view,pvh1,pvh2,pvh3).setDuration(3000).start();
    }

    private void animatorSetTest(View view){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationX",500f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX",1f,0f,1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "scaleY",1f,0f,1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000);
//        set.playSequentially(animator1,animator2,animator3);
        set.playTogether(animator1,animator2,animator3);
        set.start();
    }


    private void singleAnimatorTest(View view){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", 0, 500);
        animator.setDuration(3000);
        animator.start();
    }
}
