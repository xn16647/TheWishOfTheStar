package com.example.lou.thewishofthestar.ui.Activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.contract.ChongContract;
import com.example.lou.thewishofthestar.model.bean.MineBean.DataBeanXX;
import com.example.lou.thewishofthestar.model.bean.MineBean.ListBean;
import com.example.lou.thewishofthestar.model.bean.MineBean.StarDou;
import com.example.lou.thewishofthestar.presenter.ChongPresenter;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChongZhiActivity extends BaseActivity implements ChongContract.View{


    @BindView(R.id.c_back)
    ImageView cBack;
    @BindView(R.id.c_userphone)
    TextView cUserphone;
    @BindView(R.id.c_dounum)
    TextView cDounum;
    @BindView(R.id.chong_recyc)
    RecyclerView chongRecyc;

    private ChongContract.Presenter presenter;


    @Override
    protected int getLayout() {
        return R.layout.activity_chong_zhi;
    }

    @Override
    protected void init() {
        chongRecyc.setLayoutManager(new LinearLayoutManager(this));
        chongRecyc.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        presenter = new ChongPresenter(this);

    }

    @Override
    protected void initLoad() {
        presenter.loadData("666");

    }

    @Override
    public void showList(StarDou dou) {
        DataBeanXX data = dou.getData();
        cUserphone.setText(data.getMobile());
        cDounum.setText(data.getAmount()+"");
        List<ListBean> list = data.getList();

        SuperAdapter<ListBean> superAdapter = new SuperAdapter<ListBean>(this, list, R.layout.with_item) {
            @Override
            public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, ListBean item) {
                holder.setText(R.id.rv_money,"￥"+item.getPriceAndroid()+".0");
                holder.setText(R.id.rv_num,item.getAmountAndroid()+"");
            }
        };

        chongRecyc.setAdapter(superAdapter);

    }
}
