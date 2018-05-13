package com.example.lou.thewishofthestar.ui.Fragment.book.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.App;
import com.example.lou.thewishofthestar.model.bean.BookEntity.BookMasterBean;
import com.example.lou.thewishofthestar.ui.Fragment.book.BookDetailsActivity;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 1
 * on 2018/5/7.
 * at 北京
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>  {
   private List<BookMasterBean.DataBean.ArtcircleListBean.ListBean> list;
   private Context context;

    public BookAdapter(List<BookMasterBean.DataBean.ArtcircleListBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final BookAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.photo) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.photo.setImageDrawable(circularBitmapDrawable);
            }
        });
        holder.nackname.setText(list.get(position).getNickname());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        Date date = new Date(list.get(position).getCreateDate());
        holder.time.setText(sdf.format(date));
        holder.contentType.setText(list.get(position).getContentType());
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getContent());
        Picasso.with(context).load(list.get(position).getCoverImg()).into(holder.coverImg);
        holder.favoriteNum.setText(list.get(position).getFavoriteNum()+"");
        holder.praiseNum.setText(list.get(position).getPraiseNum()+"");

       holder.linear_c.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, BookDetailsActivity.class);
               intent.putExtra("id",list.get(position).getId());
               context.startActivity(intent);
           }
       });

       holder.comment.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, BookDetailsActivity.class);
               intent.putExtra("id",list.get(position).getId());
               context.startActivity(intent);
           }
       });

       holder.transmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                initPopupWindow();
           }
       });

    }

    @Override
    public int getItemCount()  {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView photo;
        private final TextView nackname;
        private final TextView time;
        private final Button contentType;
        private final TextView title;
        private final TextView content;
        private final ImageView coverImg;
        private final ImageView favorite;
        private final TextView favoriteNum;
        private final ImageView praise;
        private final TextView praiseNum;
        private final ImageView transmit;
        private final ImageView comment;
        private final LinearLayout linear_c;
        public ViewHolder(View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            nackname = itemView.findViewById(R.id.nackname);
            time = itemView.findViewById(R.id.time);
            contentType = itemView.findViewById(R.id.contentType);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            coverImg = itemView.findViewById(R.id.coverImg);
            favorite = itemView.findViewById(R.id.favorite);
            favoriteNum = itemView.findViewById(R.id.favoriteNum);
            praise = itemView.findViewById(R.id.praise);
            praiseNum = itemView.findViewById(R.id.praiseNum);
            transmit = itemView.findViewById(R.id.transmit);
            linear_c=itemView.findViewById(R.id.linear_c);
            comment=itemView.findViewById(R.id.comment);

        }
    }


    private void initPopupWindow() {
        View view = LayoutInflater.from(context).inflate(R.layout.share_popuwin, null);
        RadioGroup share_rg = view.findViewById(R.id.share_rg);
        RadioButton share_weixin = view.findViewById(R.id.share_weixin);
        RadioButton share_pengyouquan = view.findViewById(R.id.share_pengyouquan);
        RadioButton share_qq = view.findViewById(R.id.share_QQ);
        RadioButton share_weibo = view.findViewById(R.id.share_weibo);
        RadioButton share_fuzhi = view.findViewById(R.id.share_fuzhi);
        Button cancel = view.findViewById(R.id.cancel);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_book_reuse, null);
        View viewById = inflate.findViewById(R.id.lin);
        popupWindow.showAtLocation(viewById,Gravity.BOTTOM,0,0);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

}
