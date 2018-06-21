package com.example.zjjx.southlakebaoan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zjjx.southlakebaoan.R;
import com.example.zjjx.southlakebaoan.activity.base.BaseFragment;


/**
 * Created by linzp on 2017/10/23.
 */

public class MessageFragment extends BaseFragment {


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate( R.layout.fragment_message, container, false );


        return view;
    }

    @Override
    protected void initViews(View view) {
        super.initViews( view );


    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void addListeners() {
        super.addListeners();

    }





}
