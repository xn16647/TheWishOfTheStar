package com.example.lou.thewishofthestar.ui.Fragment.woker;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.contract.JobPartContract;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.JobPartBean;
import com.example.lou.thewishofthestar.presenter.JobPartPresenter;
import com.example.lou.thewishofthestar.ui.Fragment.woker.adapter.JobPartAdapter;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JobParticularsActivity extends BaseActivity implements JobPartContract.View{

    private ImageView exit;
    private ImageView share;
    private ImageView photo;
    private TextView nickname;
    private TextView createDate;
    private TextView source;
    private TextView content;
    private ImageView coverImg;
    private ImageView tPhoto;
    private TextView tRealname;
    private TextView tIntro;
    private Button tou_btn;
    private LinearLayout yi;
    private LinearLayout no;
    private RecyclerView recycler;
    private TextView wok_detail_aty_comment_btn;
    private TextView wok_detail_aty_comment_num;
    private RelativeLayout wok_detail_aty_comment_group;
    private TextView wok_detail;
    private TextView wok_detail_num;
    private RelativeLayout wok_detail_aty_commen;
    private EditText edit;
    @Override
    protected int getLayout() {
        return R.layout.activity_job_particulars;
    }

    @Override
    protected void init() {
         exit = findViewById(R.id.exit);
        share = findViewById(R.id.share);
        photo = findViewById(R.id.photo);
        nickname = findViewById(R.id.nickname);
        createDate = findViewById(R.id.createDate);
        source = findViewById(R.id.source);
        content = findViewById(R.id.content);
        coverImg = findViewById(R.id.coverImg);
        tPhoto = findViewById(R.id.tPhoto);
        tRealname = findViewById(R.id.tRealname);
        tIntro = findViewById(R.id.tIntro);
        tou_btn = findViewById(R.id.tou_btn);
        yi = findViewById(R.id.yi);
        no = findViewById(R.id.no);
        recycler = findViewById(R.id.recycler);
        wok_detail_aty_comment_btn = findViewById(R.id.wok_detail_aty_comment_btn);
        wok_detail_aty_comment_num = findViewById(R.id.wok_detail_aty_comment_num);
        wok_detail_aty_comment_group = findViewById(R.id.wok_detail_aty_comment_group);
        wok_detail = findViewById(R.id.wok_detail);
        wok_detail_num = findViewById(R.id.wok_detail_num);
        wok_detail_aty_commen = findViewById(R.id.wok_detail_aty_commen);
        edit = findViewById(R.id.edit);

    }

    @Override
    protected void initLoad() {
        int id = getIntent().getExtras().getInt("id");
        JobPartPresenter presenter = new JobPartPresenter(this);
        presenter.loadData(this,id);



       edit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               edit.setFocusable(true);
               edit.setFocusableInTouchMode(true);
               edit.requestFocus();
               InputMethodManager inputManager = (InputMethodManager)edit.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
               inputManager.showSoftInput(edit, 0);
           }
       });
    }

    @Override
    public void showWoker(JobPartBean jobPartBean) {
        Glide.with(this).load(jobPartBean.getData().getHomewok().getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(photo) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(JobParticularsActivity.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                photo.setImageDrawable(circularBitmapDrawable);
            }
        });
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        Date date = new Date(jobPartBean.getData().getHomewok().getCreateDate());
        createDate.setText(sdf.format(date));
        nickname.setText(jobPartBean.getData().getHomewok().getNickname());
        source.setText(jobPartBean.getData().getHomewok().getSource());
        content.setText(jobPartBean.getData().getHomewok().getContent());
        Picasso.with(this).load(jobPartBean.getData().getHomewok().getCoverImg()).into(coverImg);
        if(jobPartBean.getData().getHomewok().getTRealname()!=null){
            yi.setVisibility(View.VISIBLE);
            Glide.with(this).load(jobPartBean.getData().getHomewok().getTPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(tPhoto) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(JobParticularsActivity.this.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    tPhoto.setImageDrawable(circularBitmapDrawable);
                }
            });
            tRealname.setText(jobPartBean.getData().getHomewok().getTRealname());
            tIntro.setText(jobPartBean.getData().getHomewok().getTIntro());
        }else{
            yi.setVisibility(View.GONE);
        }
        List<JobPartBean.DataBean.CommentsBean.ListBean> list = jobPartBean.getData().getComments().getList();
        if(list.size()!=0){
            LinearLayoutManager manager = new LinearLayoutManager(this){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            JobPartAdapter adapter = new JobPartAdapter(list, this);
            recycler.setLayoutManager(manager);
            recycler.setAdapter(adapter);
        }

    }

    @Override
    public void Error(String e) {
        Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
    }
}
