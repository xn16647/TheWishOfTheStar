package com.example.lou.thewishofthestar.ui.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseActivity;
import com.example.lou.thewishofthestar.contract.SupplementContract;
import com.example.lou.thewishofthestar.presenter.SupplementPresenter;
import com.example.lou.thewishofthestar.utils.GlideCircleTransform;
import com.example.lou.thewishofthestar.utils.PermissionUtils;

import java.io.File;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;

public class SupplementActivity extends BaseActivity implements SupplementContract.View {
    protected static final int CHOOSE_PICTURE = 0;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;

    @BindView(R.id.sup_photo)
    ImageView supPhoto;
    @BindView(R.id.user_message)
    TextView userMessage;
    @BindView(R.id.boy)
    RadioButton boy;
    @BindView(R.id.girl)
    RadioButton girl;
    @BindView(R.id.radio)
    RadioGroup radio;
    @BindView(R.id.sup_name)
    EditText supName;
    @BindView(R.id.sup_psw)
    EditText supPsw;
    @BindView(R.id.supplement_btn)
    Button supplementBtn;
    @BindView(R.id.sup_photo1)
    ImageView supPhoto1;
    private int checkedRadioButtonId;
    private String phone;
    private int sex = -1;
    private SupplementContract.Presenter presenter;
    private Uri path;

    @Override
    protected int getLayout() {
        return R.layout.activity_supplement;
    }

    @Override
    protected void init() {
        PermissionUtils.isGrantExternalRW(this);
        phone = getIntent().getStringExtra("phone");
        presenter = new SupplementPresenter(this);
    }

    @Override
    protected void initLoad() {

    }


    @OnClick({R.id.sup_photo, R.id.radio, R.id.supplement_btn, R.id.sup_photo1,R.id.boy,R.id.girl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sup_photo:
                getPhoto();
                break;
            case R.id.boy:
                sex = 0;
                break;
            case R.id.girl:
                sex = 1;
                break;
            case R.id.supplement_btn:
                if (sex == -1) {
                    Toast.makeText(this, "请选择性别", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, String> map = new HashMap<>();
                map.put("nickname", supName.getText().toString().trim());
                map.put("sex", sex + "");
                map.put("photo", path.getPath());
                map.put("mobile", phone + "");
                map.put("psw", supPsw.getText().toString().trim());
                presenter.loadData(this, map);
                break;
            case R.id.sup_photo1:
                getPhoto();
                break;
        }
    }


    public void getPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, CHOOSE_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case CHOOSE_PICTURE:
                    showImage(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    //加载图片
    private void showImage(Uri imaePath) {
        path = imaePath;
        Glide.with(this).load(path).transform(new GlideCircleTransform(this)).into(supPhoto);
        supPhoto1.setVisibility(View.GONE);
    }

    protected void setImageToView(Intent data) {

    }

    @Override
    public void showSuccees() {
        startActivity(new Intent(this,LoginActivity.class));
    }

    @Override
    public void Message(String e) {
        Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
    }
}
