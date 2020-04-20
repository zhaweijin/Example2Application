package com.example2.test.dialog;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.example2.test.R;

import butterknife.BindView;


public class ConfirmDialog extends BaseDialog {


    /********************************
     * ******************************
     * ******************************
     * 注意layout布局方式，在layout里面控制大小，不在代码里面控制
     * ******************************
     * ******************************
     * ******************************
     * ******************************
     */






    private static final String TAG = "input";

    @BindView(R.id.save)
    FrameLayout save;


    @Override
    public int getLayoutId() {
        return R.layout.dialog_test;
    }

    public ConfirmDialog(@NonNull Context context) {
        super(context, R.style.dialog);
        init();
    }



    private void init() {
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.CENTER;
        getWindow().setAttributes(layoutParams);
    }

    public void initData(){
        save.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.save:
                    Toast.makeText(mContext,"ttttt",Toast.LENGTH_LONG).show();
                    dismiss();
                    break;

            }
        }
    };




}
