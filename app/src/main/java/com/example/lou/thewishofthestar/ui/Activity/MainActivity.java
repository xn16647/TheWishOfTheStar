package com.example.lou.thewishofthestar.ui.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.ui.Fragment.MineFragment;
import com.example.lou.thewishofthestar.ui.Fragment.ProphesyFragment;
import com.example.lou.thewishofthestar.ui.Fragment.TeacherFragment;
import com.example.lou.thewishofthestar.ui.Fragment.ValuableBookFragment;
import com.example.lou.thewishofthestar.ui.Fragment.WokerFragment;


public class   MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    private FrameLayout home_frame;
    private RadioButton home_teacher_btn;
    private RadioButton home_woker_btn;
    private RadioButton home_book_btn;
    private RadioButton home_yugao_btn;
    private RadioButton home_mine_btn;
    private RadioGroup radioGroup;
    private RadioButton lastRadion;
    public ImageView myselt_head;
    public LinearLayout title_liner;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;

    }

    @Override
    protected void init() {
        home_frame = (FrameLayout) findViewById(R.id.home_frame);
        radioGroup = findViewById(R.id.radiogroup);
        home_teacher_btn = (RadioButton) findViewById(R.id.home_teacher_btn);
        home_woker_btn = (RadioButton) findViewById(R.id.home_woker_btn);
        home_book_btn = (RadioButton) findViewById(R.id.home_book_btn);
        home_yugao_btn = (RadioButton) findViewById(R.id.home_yugao_btn);
        home_mine_btn = (RadioButton) findViewById(R.id.home_mine_btn);
        radioGroup.setOnCheckedChangeListener(this);
        myselt_head = findViewById(R.id.myselt_head);
        title_liner = findViewById(R.id.title_liner);

    }

    @Override
    protected void initLoad() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getCheckedRadioButtonId()) {
            case R.id.home_teacher_btn:
                setBtnTextColor(home_teacher_btn);
                setContentView(TeacherFragment.class);
                break;
            case R.id.home_woker_btn:
                setBtnTextColor(home_woker_btn);
                setContentView(WokerFragment.class);
                break;
            case R.id.home_book_btn:
                setBtnTextColor(home_book_btn);
                setContentView(ValuableBookFragment.class);
                break;
            case R.id.home_yugao_btn:
                setBtnTextColor(home_yugao_btn);
                setContentView(ProphesyFragment.class);
                break;
            case R.id.home_mine_btn:
                myselt_head.setVisibility(View.VISIBLE);
                title_liner.setVisibility(View.GONE);
                setBtnTextColor(home_mine_btn);
                setContentView(MineFragment.class);
                break;
        }
    }

    private void setBtnTextColor(RadioButton home_teacher_btn) {
        home_teacher_btn.setTextColor(Color.parseColor("#4169E1"));
        if (lastRadion != null) {
            lastRadion.setTextColor(Color.parseColor("#c3c3c3"));
        }
        lastRadion = home_teacher_btn;
    }

}
