package com.example2.test.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example2.test.R;

public class SecondFragment extends BackHandledFragment {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_second_test, null);
        return mView;
    }

    @Override
    protected boolean onBackPressed() {
        return false;
    }

}