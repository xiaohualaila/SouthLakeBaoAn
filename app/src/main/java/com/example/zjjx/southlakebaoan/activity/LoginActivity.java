package com.example.zjjx.southlakebaoan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zjjx.southlakebaoan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    private boolean isPasswordType = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind( this);

    }

    @OnClick({R.id.seePassword,R.id.login,R.id.forget,R.id.to_register})
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
                String ph =phone.getText().toString();
                String p =password.getText().toString();
                if(TextUtils.isEmpty(ph)){
                    Toast.makeText(this,"手机号码或者身份证不能为空！",Toast.LENGTH_LONG);
                    return;
                }else if(TextUtils.isEmpty(p)){
                    Toast.makeText(this,"密码不能为空！",Toast.LENGTH_LONG);
                    return;
                }
               //todo登录
                break;
            case R.id.forget:

                break;
            case R.id.to_register:

                break;
        }

    }
}
