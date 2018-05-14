package com.example.lou.thewishofthestar.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.contract.LoginContract;
import com.example.lou.thewishofthestar.presenter.LoginPresenter;
import com.example.lou.thewishofthestar.ui.Fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    @BindView(R.id.login_close)
    TextView loginClose;
    @BindView(R.id.register_text)
    TextView registerText;
    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_psw)
    EditText loginPsw;
    @BindView(R.id.forget_psw)
    TextView forgetPsw;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.weixin_login1)
    TextView weixinLogin1;
    @BindView(R.id.qq_login1)
    TextView qqLogin1;
    @BindView(R.id.weibo_login1)
    TextView weiboLogin1;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    private LoginContract.Presenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        presenter = new LoginPresenter(this);
    }

    @Override
    protected void initLoad() {

    }

    @OnClick({R.id.login_close, R.id.register_text, R.id.forget_psw, R.id.login_btn, R.id.qq_login1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_close:
                finish();
                break;
            case R.id.register_text:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.forget_psw:
                break;
            case R.id.login_btn:
                presenter.loadData(this);
                break;
            case R.id.qq_login1:
                break;
        }
    }

    @Override
    public void showSuccees(int id) {
        SharedPreferences loginState = getSharedPreferences("loginState", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = loginState.edit();
        edit.putBoolean("flag",true);
        edit.putInt("id",id);
        edit.commit();
        finish();
    }

    @Override
    public void Message(String e) {
        Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getPhone() {
        return loginPhone.getText().toString().trim();
    }

    @Override
    public String getPsw() {
        return loginPsw.getText().toString().trim();
    }
}
