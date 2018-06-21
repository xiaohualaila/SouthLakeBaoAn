package com.example.zjjx.southlakebaoan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import com.example.zjjx.southlakebaoan.R;
import com.example.zjjx.southlakebaoan.activity.base.BaseFragment;

import net.qiujuer.genius.ui.widget.Button;

import java.util.ArrayList;


/**
 * Created by linzp on 2017/10/23.
 */

public class WorkFragment extends BaseFragment {


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate( R.layout.fragment_work, container, false );


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
