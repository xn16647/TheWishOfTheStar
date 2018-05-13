package com.example.lou.thewishofthestar.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.contract.MineContract;
import com.example.lou.thewishofthestar.contract.RegisterContract;
import com.example.lou.thewishofthestar.presenter.ReigisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Cache;

public class RegisterActivity extends BaseActivity implements RegisterContract.View{
    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_code)
    EditText registerCode;
    @BindView(R.id.register_getCode)
    TextView registerGetCode;
    @BindView(R.id.register_btn)
    Button registerBtn;
    @BindView(R.id.weixin_login)
    TextView weixinLogin;
    @BindView(R.id.qq_login)
    TextView qqLogin;
    @BindView(R.id.weibo_login)
    TextView weiboLogin;
    private RegisterContract.Presenter presenter;

    @Override
    protected int getLayout() {
        return R.layout.register_layout;
    }

    @Override
    protected void init() {
        presenter = new ReigisterPresenter(this);
    }

    @Override
    protected void initLoad() {

    }


    @OnClick({R.id.register_getCode, R.id.register_btn, R.id.weixin_login, R.id.qq_login, R.id.weibo_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_getCode:
                presenter.getRegisterCode(this);
                break;
            case R.id.register_btn:
                presenter.goRegister();
                break;
            case R.id.weixin_login:
                break;
            case R.id.qq_login:
                break;
            case R.id.weibo_login:
                break;
        }
    }


    @Override
    public void Toast(String e) {
        Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Success() {
        Intent intent = new Intent(this,SupplementActivity.class);
        intent.putExtra("phone",getPhone());
        startActivity(intent);
    }

    @Override
    public void load() {
    }


    @Override
    public String getCode() {
        return registerCode.getText().toString().trim();
    }

    @Override
    public void isExist() {
        presenter.loadCode();
    }

    @Override
    public String getPhone() {
        return registerPhone.getText().toString().trim();
    }
}
