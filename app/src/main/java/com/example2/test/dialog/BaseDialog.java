package com.example2.test.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by carter on 4/11/17.
 */

public abstract class BaseDialog extends Dialog implements DialogInterface.OnDismissListener{

    private CompositeDisposable mCompositeDispoable;

    private String tag = "BaseDialog";
    public Context mContext;
    public View mRootView;

    public abstract int getLayoutId();

    public BaseDialog(Context context){
        super(context);
        this.mContext = context;
    }

    public BaseDialog(Context context, int type){
        super(context,type);
        this.mContext = context;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (this.mCompositeDispoable != null) {
            this.mCompositeDispoable.dispose();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == mRootView) {
            mRootView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
        }
        setContentView(mRootView);
        ButterKnife.bind(this,mRootView);
    }



}
