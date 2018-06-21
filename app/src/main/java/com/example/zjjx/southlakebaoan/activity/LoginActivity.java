package com.example.zjjx.southlakebaoan.activity;

import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.zjjx.southlakebaoan.R;
import com.example.zjjx.southlakebaoan.activity.base.BaseActivity;
import com.example.zjjx.southlakebaoan.dialog.Apk_dialog;
import com.example.zjjx.southlakebaoan.dialog.UpAppDialog;
import com.example.zjjx.southlakebaoan.retrofit.Api;
import com.example.zjjx.southlakebaoan.retrofit.ConnectUrl;
import com.example.zjjx.southlakebaoan.util.DownApk;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class LoginActivity extends BaseActivity implements DownApk.ProgressState{
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    private boolean isPasswordType = true;


    Apk_dialog apk_dialog;
    SeekBar seek;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {

        apk_dialog = new Apk_dialog( this );
    }

    @OnClick({R.id.seePassword,R.id.login,R.id.forget})
    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.seePassword:
                if (password.getText().length() > 0) {
                    isPasswordType = !isPasswordType;
                    password.setInputType( isPasswordType ? (InputType.TYPE_CLASS_TEXT | InputType
                            .TYPE_TEXT_VARIATION_PASSWORD) : InputType
                            .TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                }
                break;
            case R.id.login:
//                String ph =phone.getText().toString();
//                String p =password.getText().toString();
//                if(TextUtils.isEmpty(ph)){
//                    toastLong("手机号码或者身份证不能为空!");
//                    return;
//                }else if(TextUtils.isEmpty(p)){
//                    toastLong("密码不能为空!");
//                    return;
//                }
               //todo登录
                openActivity(MainActivity.class);
                break;
            case R.id.forget:
                openActivity(forgetActivity.class);
                break;

        }

    }

    private void updateApp(){
        final UpAppDialog  upAppDialog = UpAppDialog.getInstance("更新说明。。。\n放大福利费克反对法\n的非法上访");
        upAppDialog.show(getSupportFragmentManager(), new UpAppDialog.OnDialogButtonClickListener() {
            @Override
            public void okButtonClick() {
                toastLong("更新!");
                upAppDialog.dismiss();

                apk_dialog.show();
                apk_dialog.setCancelable( false );
                seek = apk_dialog.getSeekBar();
                //下载更新
//                        DownApk downApk = new DownApk("",getApplicationContext(), "");
//                        downApk.downApk();
//                        downApk.setProgressState(LoginActivity.this);
            }

            @Override
            public void cancelButtonClick() {
                upAppDialog.dismiss();
            }
        });
    }

    public void getAppVersion(){
        Api.getBaseApiWithOutFormat(ConnectUrl.URL)
                .getAppVer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<JSONObject>() {
                               @Override
                               public void call(JSONObject jsonObject) {

                                   //

                               }
                           }, new Action1<Throwable>() {
                               @Override
                               public void call(Throwable throwable) {

                               }
                           }
                );
    }


    @Override
    public void setSeek(final int dl_progress) {
        if (dl_progress >= 100) {
            runOnUiThread( new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub

                    toastLong("下载完成");
                    apk_dialog.dismiss();
                }
            } );
        } else {
            runOnUiThread( new Runnable() {
                @Override
                public void run() {
                    seek.setProgress( dl_progress );
                }
            } );
        }
    }
}
