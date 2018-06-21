package com.example.zjjx.southlakebaoan.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zjjx.southlakebaoan.R;
import com.example.zjjx.southlakebaoan.activity.base.BaseActivity;
import com.example.zjjx.southlakebaoan.bean.OneDay;


import java.util.Calendar;
import java.util.List;

/**
 * Created by linzp on 2017/10/23.
 */

public class RvWeekAdapter extends RecyclerView.Adapter<RvWeekAdapter.MyViewHolder> {


    class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_day;
        TextView weekDay,day;
        View type;
        public MyViewHolder(View view) {
            super( view );
            ll_day = view.findViewById( R.id.ll_day );
            weekDay = view.findViewById( R.id.weekDay );
            day = view.findViewById( R.id.day );
            type = view.findViewById( R.id.type );
        }
    }

    Context context;
    List<OneDay> topdata;

    public RvWeekAdapter(Context context, List<OneDay> topdata) {
        this.context = context;
        this.topdata = topdata;
    }

    @Override
    public int getItemCount() {
        return topdata.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder( LayoutInflater.from( context ).inflate( R
                .layout.layout_day, parent, false ) );

        return holder;
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        WindowManager wm = ((BaseActivity) context).getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams ruleParams = holder.ll_day.getLayoutParams();
        ruleParams.width = width/7;
        holder.ll_day.setLayoutParams( ruleParams );

        OneDay oneDay = topdata.get(position);
        holder.weekDay.setText(oneDay.getWeekDay());
        holder.day.setText(oneDay.getDay());
        int n = Integer.parseInt(oneDay.getWorkType());
        if(n == 1){
            holder.day.setBackgroundColor(R.color.app_style_blue);
        }else if(n == 2){
            holder.day.setBackgroundColor(R.color.picback);
        }else if(n == 3){
            holder.day.setBackgroundColor(R.color.colorAccent);
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}