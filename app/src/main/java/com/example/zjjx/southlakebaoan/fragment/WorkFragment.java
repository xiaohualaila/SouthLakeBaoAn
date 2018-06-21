package com.example.zjjx.southlakebaoan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.zjjx.southlakebaoan.adapter.RvWeekAdapter;
import com.example.zjjx.southlakebaoan.bean.OneDay;

import net.qiujuer.genius.ui.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by linzp on 2017/10/23.
 */

public class WorkFragment extends BaseFragment {

    private RecyclerView rv_week;
    private RvWeekAdapter mAdapter;
    private List<OneDay> workDataList = new ArrayList<>();
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate( R.layout.fragment_work, container, false );
        rv_week = (RecyclerView) view.findViewById( R.id.rv_week );
        rv_week.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        workDataList.add(new OneDay("1","日","0"));
        workDataList.add(new OneDay("2","一","2"));
        workDataList.add(new OneDay("3","二","1"));
        workDataList.add(new OneDay("4","三","3"));
        workDataList.add(new OneDay("5","四","1"));
        workDataList.add(new OneDay("6","五","1"));
        workDataList.add(new OneDay("7","六","1"));

        mAdapter = new RvWeekAdapter(getActivity(),workDataList);
        rv_week.setItemAnimator(new DefaultItemAnimator());
       //设置适配器
        rv_week.setAdapter(mAdapter);
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
