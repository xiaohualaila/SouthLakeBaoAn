package com.example.zjjx.southlakebaoan.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.example.zjjx.southlakebaoan.R;
import com.example.zjjx.southlakebaoan.activity.base.BaseActivity;
import com.example.zjjx.southlakebaoan.fragment.ListFragment;
import com.example.zjjx.southlakebaoan.fragment.MessageFragment;
import com.example.zjjx.southlakebaoan.fragment.WorkFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.box_drawer)
    DrawerLayout box_drawer;
    @BindView(R.id.drawer_layout)
    LinearLayout drawerLayout;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.box_search)
    FrameLayout boxSearch;
    @BindView(R.id.title_lay)
    RelativeLayout titleLay;
    private long mExitTime;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> tabs = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        tabs.add("工作");
        tabs.add("消息");
        tabs.add("通讯录");
        mFragmentList.add( new WorkFragment() );
        mFragmentList.add( new MessageFragment() );
        mFragmentList.add( new ListFragment() );

        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        view_pager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        //关联ViewPager和TabLayout
        tabLayout.setupWithViewPager(view_pager);
        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==2){
                    boxSearch.setVisibility(View.VISIBLE);
                    titleLay.setVisibility(View.GONE);
                }else {
                    boxSearch.setVisibility(View.GONE);
                    titleLay.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
    }

    class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        //显示标签上的文字
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }
    }

    @OnClick({R.id.back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                //将左侧栏显示出来
                boolean drawerOpen = box_drawer.isDrawerOpen( drawerLayout );
                if (!drawerOpen) {
                    box_drawer.openDrawer( drawerLayout );
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        boolean drawerOpen = box_drawer.isDrawerOpen( drawerLayout );
        if (drawerOpen) {
            box_drawer.closeDrawer( drawerLayout );
        } else {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - mExitTime > 2000) {
                toastShort("再按一次退出程序");
                mExitTime = timeInMillis;
            } else {
               finish();
            }
            return;
        }
    }

}
