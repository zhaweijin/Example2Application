package com.example2.test.fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example2.test.R;

public class FirstFragment extends BackHandledFragment {
    private View myView;
    private Button btnSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_first_test, null);
        initView();
        return myView;
    }

    private void initView() {
        btnSecond = (Button) myView.findViewById(R.id.button);
        btnSecond.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                SecondFragment fragment = new SecondFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.firstFragment, fragment);
                ft.addToBackStack("tag");
                ft.commit();
            }
        });
    }

    @Override
    protected boolean onBackPressed() {
        return false;
    }

}