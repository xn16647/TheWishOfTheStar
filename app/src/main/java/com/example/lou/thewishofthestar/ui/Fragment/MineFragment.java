package com.example.lou.thewishofthestar.ui.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.App;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.contract.MineContract;
import com.example.lou.thewishofthestar.model.bean.MineBean.DataBeanX;
import com.example.lou.thewishofthestar.model.bean.MineBean.UserInfo;
import com.example.lou.thewishofthestar.presenter.MinePresenter;
import com.example.lou.thewishofthestar.ui.Activity.ChongZhiActivity;
import com.example.lou.thewishofthestar.ui.Activity.LoginActivity;
import com.example.lou.thewishofthestar.ui.Activity.MainActivity;
import com.example.lou.thewishofthestar.ui.Activity.MyIdentification;
import com.example.lou.thewishofthestar.ui.Activity.MyOrderActivity;
import com.example.lou.thewishofthestar.ui.Activity.RegisterActivity;
import com.example.lou.thewishofthestar.ui.Activity.SettingActivity;

import java.nio.channels.FileChannel;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment implements MineContract.View {

    @BindView(R.id.mine_chat)
    ImageView mineChat;
    @BindView(R.id.mine_setting)
    ImageView mineSetting;
    @BindView(R.id.unLogin_head)
    ImageView unLoginHead;
    @BindView(R.id.mine_textview)
    TextView mineTextview;
    @BindView(R.id.unLogin_btn)
    Button unLoginBtn;
    @BindView(R.id.unRegister_btn)
    Button unRegisterBtn;
    @BindView(R.id.gologin_Layout)
    ConstraintLayout gologinLayout;
    @BindView(R.id.useful_default_userimg)
    ImageView usefulDefaultUserimg;
    @BindView(R.id.useful_name)
    TextView usefulName;
    @BindView(R.id.useful_myInfo)
    TextView usefulMyInfo;
    @BindView(R.id.useful_opus)
    TextView usefulOpus;
    @BindView(R.id.useful_invitation)
    TextView usefulInvitation;
    @BindView(R.id.useful_follow)
    TextView usefulFollow;
    @BindView(R.id.useful_fans)
    TextView usefulFans;
    @BindView(R.id.useful_unPayment)
    LinearLayout usefulUnPayment;
    @BindView(R.id.useful_unUse)
    LinearLayout usefulUnUse;
    @BindView(R.id.useful_unQuit)
    LinearLayout usefulUnQuit;
    @BindView(R.id.useful_order)
    LinearLayout usefulOrder;
    @BindView(R.id.linear_group_img)
    LinearLayout linearGroupImg;
    @BindView(R.id.useful_pay)
    LinearLayout usefulPay;
    @BindView(R.id.useful_collect)
    LinearLayout usefulCollect;
    @BindView(R.id.useful_hobby)
    LinearLayout usefulHobby;
    @BindView(R.id.useful_authentication)
    LinearLayout usefulAuthentication;
    @BindView(R.id.useful_gift)
    LinearLayout usefulGift;
    @BindView(R.id.useful_logined_Layout)
    ConstraintLayout usefulLoginedLayout;
    Unbinder unbinder;
    private boolean flag;
    private SharedPreferences order;
    private SharedPreferences.Editor edit;
    private Intent intent;
    private MineContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init() {
        SharedPreferences loginState = getContext().getSharedPreferences("loginState", Context.MODE_PRIVATE);
        flag = loginState.getBoolean("flag", false);
        presenter = new MinePresenter(this);

        intent = new Intent(getContext(), MyOrderActivity.class);
        if (flag) {
            int id = loginState.getInt("id", -1);
            Log.d("MineFragment", "id:" + id);
            presenter.getUserInfo(661);

            showLogined();
        } else {
            showUnLogin();
        }

    }


    @Override
    protected void initLoad() {

    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            ((MainActivity) getActivity()).title_liner.setVisibility(View.VISIBLE);
            ((MainActivity) getActivity()).myselt_head.setVisibility(View.GONE);
        } else {
            ((MainActivity) getActivity()).title_liner.setVisibility(View.GONE);
            ((MainActivity) getActivity()).myselt_head.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mine_chat, R.id.mine_setting, R.id.unLogin_head, R.id.unLogin_btn, R.id.unRegister_btn, R.id.gologin_Layout, R.id.useful_default_userimg, R.id.useful_name, R.id.useful_myInfo, R.id.useful_opus, R.id.useful_invitation, R.id.useful_follow, R.id.useful_fans, R.id.useful_unPayment, R.id.useful_unUse, R.id.useful_unQuit, R.id.useful_order, R.id.useful_pay, R.id.useful_collect, R.id.useful_hobby, R.id.useful_authentication, R.id.useful_gift, R.id.useful_logined_Layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mine_chat:
                break;
            case R.id.mine_setting:
                if(flag){
                    startActivity(new Intent(getContext(), SettingActivity.class));
                }
                break;
            case R.id.unLogin_head:
                break;
            case R.id.unLogin_btn:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.unRegister_btn:
                startActivity(new Intent(getContext(), RegisterActivity.class));
                break;
            case R.id.gologin_Layout:
                break;
            case R.id.useful_default_userimg:
                break;
            case R.id.useful_name:
                break;
            case R.id.useful_myInfo:
                break;
            case R.id.useful_opus:
                break;
            case R.id.useful_invitation:
                break;
            case R.id.useful_follow:
                break;
            case R.id.useful_fans:
                break;
            case R.id.useful_unPayment:
                intent.putExtra("order","dai");
                startActivity(intent);
                break;
            case R.id.useful_unUse:
                intent.putExtra("order","dai");
                startActivity(intent);
                break;
            case R.id.useful_unQuit:
                intent.putExtra("order","dai");
                startActivity(intent);
                break;
            case R.id.useful_order:
                intent.putExtra("order","dai");
                startActivity(intent);
                break;
            case R.id.useful_pay:
                startActivity(new Intent(getContext(),ChongZhiActivity.class));
                break;
            case R.id.useful_collect:
                break;
            case R.id.useful_hobby:
                break;
            case R.id.useful_authentication:
                startActivity(new Intent(getContext(), MyIdentification.class));
                break;
            case R.id.useful_gift:
                intent.putExtra("order","gift");
                startActivity(intent);
                break;
            case R.id.useful_logined_Layout:
                break;
        }
    }


    @Override
    public void showSuccess(UserInfo message) {
        DataBeanX data = message.getData();
        usefulName.setText(data.getNickname());
    }

    @Override
    public void Message(String e) {
        Toast.makeText(getContext(), e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLogined() {
        usefulLoginedLayout.setVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        gologinLayout.setVisibility(View.GONE);
    }

    @Override
    public void showUnLogin() {
        gologinLayout.setVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        usefulLoginedLayout.setVisibility(View.GONE);
    }

}
