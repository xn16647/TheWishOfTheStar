package com.example.lou.thewishofthestar.ui.Fragment.book;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.contract.BookParticularsContract;
import com.example.lou.thewishofthestar.model.bean.BookEntity.ParticularsBookBean;
import com.example.lou.thewishofthestar.presenter.BookParticularsPreseenter;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailsActivity extends BaseActivity implements BookParticularsContract.View {


    @BindView(R.id.exit)
    ImageView exit;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.nickname)
    TextView nickname;
    @BindView(R.id.createDate)
    TextView createDate;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.coverImg)
    ImageView coverImg;
    @BindView(R.id.no)
    LinearLayout no;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.pinglun)
    TextView pinglun;
    @BindView(R.id.collect)
    CheckBox collect;
    @BindView(R.id.wok_detail_aty_comment_btn)
    TextView wokDetailAtyCommentBtn;
    @BindView(R.id.wok_detail_aty_comment_num)
    TextView wokDetailAtyCommentNum;
    @BindView(R.id.wok_detail_aty_comment_group)
    RelativeLayout wokDetailAtyCommentGroup;
    @BindView(R.id.wok_detail)
    TextView wokDetail;
    @BindView(R.id.wok_detail_num)
    TextView wokDetailNum;
    @BindView(R.id.wok_detail_aty_commen)
    RelativeLayout wokDetailAtyCommen;
    @BindView(R.id.xianshi)
    LinearLayout xianshi;
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.fasong)
    Button fasong;
    @BindView(R.id.yinchang)
    LinearLayout yinchang;

    @Override
    protected int getLayout() {
        return R.layout.activity_book_details;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        Log.e("TAG", id + "");
        BookParticularsPreseenter preseenter = new BookParticularsPreseenter(this);
        preseenter.loadData(this, HttpHelp.getUserId(this),id);
    }

    @Override
    protected void initLoad() {

    }

    @Override
    public void showSuccees(ParticularsBookBean particularsBookBean) {
        particularsBookBean.getMessage();
        Log.e("TAG",particularsBookBean.getMessage());
    }

    @Override
    public void Error(String e) {

    }
}
