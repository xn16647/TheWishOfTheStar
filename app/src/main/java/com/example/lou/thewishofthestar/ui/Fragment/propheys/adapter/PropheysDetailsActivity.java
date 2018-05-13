package com.example.lou.thewishofthestar.ui.Fragment.propheys.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.contract.DetailsContract;
import com.example.lou.thewishofthestar.data.Constant;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.DetailsBean;
import com.example.lou.thewishofthestar.presenter.DetailsPresenter;
import com.example.lou.thewishofthestar.utils.HttpHelp;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class PropheysDetailsActivity extends BaseActivity implements DetailsContract.View, View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    private ImageView coverImg;
    private ImageView recede;
    private ImageView share;
    private TextView reservationNum;
    private TextView subscribeNum;
    private TextView startDate;
    private TextView address;
    private TextView price;
    private WebView web;
    private RadioButton collect;
    private TextView phone;
    private TextView order;
    private DetailsBean.DataBean data;
    private LinearLayout prophers_linear;
    private RadioButton share_weixin;
    private RadioButton share_pengyouquan;
    private RadioButton share_qq;
    private RadioButton share_weibo;
    private RadioButton share_fuzhi;
    private Button cancel;
    private RadioGroup share_rg;
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected int getLayout() {
        return R.layout.activity_propheys_details;
    }

    @Override
    protected void init() {
        prophers_linear=findViewById(R.id.prophers_linear);
        coverImg = findViewById(R.id.coverImg);
        recede = findViewById(R.id.recede);
        share = findViewById(R.id.share);
        reservationNum = findViewById(R.id.reservationNum);
        subscribeNum = findViewById(R.id.subscribeNum);
        startDate = findViewById(R.id.startDate);
        address = findViewById(R.id.address);
        price = findViewById(R.id.price);
        web = findViewById(R.id.web);
        collect = findViewById(R.id.collect);
        phone = findViewById(R.id.phone);
        order = findViewById(R.id.order);

        phone.setOnClickListener(this);
        recede.setOnClickListener(this);
        share.setOnClickListener(this);


    }

    @Override
    protected void initLoad() {
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        DetailsPresenter presenter = new DetailsPresenter(this);
        presenter.loadData(this, HttpHelp.getUserId(this),id);
    }

    @Override
    public void showSuccees(final DetailsBean detailsBean) {
        data = detailsBean.getData();
        Picasso.with(this).load(detailsBean.getData().getCoverImg()).into(coverImg);
        reservationNum.setText(detailsBean.getData().getReservationNum()+"");
        subscribeNum.setText(detailsBean.getData().getSubscribeNum()+"");
        address.setText(detailsBean.getData().getAddress());
        price.setText(detailsBean.getData().getPrice()+"");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(detailsBean.getData().getStartDate());
        startDate.setText(sdf.format(date));

        web.loadUrl(String.format("http://share.univstar.com/view/course.html?courseid=%s",detailsBean.getData().getId()));
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                web.loadUrl(String.format("http://share.univstar.com/view/course.html?courseid=%s",detailsBean.getData().getId()));
               return super.shouldOverrideUrlLoading(view, request);
            }
        });





    }

    @Override
    public void Error(String e) {
        Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phone:
                Intent dialIntent =  new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + data.getMobile()));
                startActivity(dialIntent);
                break;
            case R.id.recede:
                finish();
                break;
            case R.id.share:
                initPopupWindow();
                break;
        }
    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.share_popuwin, null);
        share_rg = view.findViewById(R.id.share_rg);
        share_rg.setOnCheckedChangeListener(this);
        share_weixin = view.findViewById(R.id.share_weixin);
        share_pengyouquan = view.findViewById(R.id.share_pengyouquan);
        share_qq = view.findViewById(R.id.share_QQ);
        share_weibo = view.findViewById(R.id.share_weibo);
        share_fuzhi = view.findViewById(R.id.share_fuzhi);

        cancel = view.findViewById(R.id.cancel);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.showAtLocation(prophers_linear,Gravity.BOTTOM,0,0);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.share_weixin:

                break;
            case R.id.share_pengyouquan:

                break;
            case R.id.share_QQ:
                UMShareAPI.get(this).getPlatformInfo(PropheysDetailsActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.share_weibo:
                break;
            case R.id.share_fuzhi:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
