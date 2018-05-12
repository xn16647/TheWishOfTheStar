package com.example.lou.thewishofthestar.ui.Fragment.book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;

public class BookDetailsActivity extends BaseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_book_details;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        Log.e("TAG",id+"");
    }

    @Override
    protected void initLoad() {

    }
}
