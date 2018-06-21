package com.example.zjjx.southlakebaoan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.zjjx.southlakebaoan.R;
import com.example.zjjx.southlakebaoan.retrofit.Api;
import com.example.zjjx.southlakebaoan.retrofit.ConnectUrl;
import com.example.zjjx.southlakebaoan.util.DownApk;

import org.json.JSONObject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        myTimer.start();
    }
    //倒计时
    private CountDownTimer myTimer = new CountDownTimer( 1000, 1000 ) {
        @Override
        public void onTick(long l) {
        }

        @Override
        public void onFinish() {
                //获取版本信息
                startActivity( new Intent( StartActivity.this, LoginActivity.class ) );
                finish();


        }
    };


}
