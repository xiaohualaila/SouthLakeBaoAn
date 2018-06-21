package com.example.zjjx.southlakebaoan.activity;

import android.view.View;

import com.example.zjjx.southlakebaoan.R;
import com.example.zjjx.southlakebaoan.activity.base.BaseActivity;

import butterknife.OnClick;

public class forgetActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    protected void initViews() {

    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
