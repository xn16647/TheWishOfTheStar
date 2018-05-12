package com.example.lou.thewishofthestar.ui.Fragment.woker.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;
import com.example.lou.thewishofthestar.ui.Fragment.woker.JobParticularsActivity;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 1
 * on 2018/5/4.
 * at 北京
 */

public class  NoppsycheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
   private List<WokerMasterBean.DataBean.ListBean> list;
   private Context context;
    public NoppsycheAdapter(List<WokerMasterBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getItemViewType(int position) {
        int type;
        if(list.get(position).getTUserType()==0){
            type=0;
        }else{
            type=1;
        }
        return type;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
       switch (viewType){
           case 0:
               View view = LayoutInflater.from(context).inflate(R.layout.woker_steal_two, parent, false);
               holder=new OneViewHolder(view);
               break;
           case 1:
               View view1 = LayoutInflater.from(context).inflate(R.layout.woker_steal, parent, false);
               holder=new TwoViewHolder(view1);
               break;
       }
        return holder;
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof OneViewHolder){
            Glide.with(context).load(list.get(position).getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((OneViewHolder)holder).photo) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ((OneViewHolder)holder).photo.setImageDrawable(circularBitmapDrawable);
                }
            });
            ((OneViewHolder)holder).nackname.setText(list.get(position).getNickname());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
            Date date = new Date(list.get(position).getCreateDate());
            ((OneViewHolder)holder).time.setText(sdf.format(date));
            ((OneViewHolder)holder).source.setText(list.get(position).getSource());
            ((OneViewHolder)holder).content.setText(list.get(position).getContent());
            Picasso.with(context).load(list.get(position).getCoverImg()).into(((OneViewHolder)holder).coverImg);
            ((OneViewHolder)holder).linear_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, JobParticularsActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    context.startActivity(intent);
                }
            });

            ((OneViewHolder)holder).comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, JobParticularsActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    context.startActivity(intent);
                }
            });
            ((OneViewHolder)holder).reward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, JobParticularsActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    context.startActivity(intent);
                }
            });

        }else if (holder instanceof TwoViewHolder){
            Glide.with(context).load(list.get(position).getPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((TwoViewHolder)holder).photo) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ((TwoViewHolder)holder).photo.setImageDrawable(circularBitmapDrawable);
                }
            });
            ((TwoViewHolder)holder).nackname.setText(list.get(position).getNickname());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
            Date date = new Date(list.get(position).getCreateDate());
            ((TwoViewHolder)holder).time.setText(sdf.format(date));
            ((TwoViewHolder)holder).source.setText(list.get(position).getSource());
            ((TwoViewHolder)holder).content.setText(list.get(position).getContent());
            Picasso.with(context).load(list.get(position).getCoverImg()).into(((TwoViewHolder)holder).coverImg);
            Glide.with(context).load(list.get(position).getTPhoto()).asBitmap().centerCrop().into(new BitmapImageViewTarget(((TwoViewHolder)holder).tPhoto) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    ((TwoViewHolder)holder).tPhoto.setImageDrawable(circularBitmapDrawable);
                }
            });
            ((TwoViewHolder)holder).tRealname.setText(list.get(position).getTRealname());
            ((TwoViewHolder)holder).tIntro.setText(list.get(position).getTIntro());

            ((TwoViewHolder)holder).comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, JobParticularsActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    context.startActivity(intent);
                }
            });
            ((TwoViewHolder)holder).reward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, JobParticularsActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    context.startActivity(intent);
                }
            });

            ((TwoViewHolder)holder).linear_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, JobParticularsActivity.class);
                    intent.putExtra("id",list.get(position).getId());
                    context.startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list.isEmpty()?0:list.size();
    }



    class OneViewHolder extends RecyclerView.ViewHolder{
        private final LinearLayout linear_name;
        private final LinearLayout linear_content;
        private final ImageView photo;
        private final TextView nackname;
        private final TextView time;
        private final TextView source;
        private final TextView content;
        private final ImageView coverImg;
        private final ImageView comment;
        private final ImageView praise;
        private final TextView praise_num;
        private final ImageView reward;
        private final TextView reward_num;
        private final ImageView transmit;

        public OneViewHolder(View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            nackname = itemView.findViewById(R.id.nackname);
            time = itemView.findViewById(R.id.time);
            source = itemView.findViewById(R.id.source);
            content = itemView.findViewById(R.id.content);
            coverImg = itemView.findViewById(R.id.coverImg);
            comment = itemView.findViewById(R.id.comment);
            praise = itemView.findViewById(R.id.praise);
            praise_num = itemView.findViewById(R.id.praise_num);
            reward = itemView.findViewById(R.id.reward);
            reward_num = itemView.findViewById(R.id.reward_num);
            transmit = itemView.findViewById(R.id.transmit);
            linear_name=itemView.findViewById(R.id.linear_name);
            linear_content=itemView.findViewById(R.id.linear_content);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        private final ImageView photo;
        private final TextView nackname;
        private final TextView time;
        private final TextView source;
        private final TextView content;
        private final ImageView coverImg;
        private final ImageView tPhoto;
        private final TextView tRealname;
        private final TextView tIntro;
        private final Button tou_btn;
        private final ImageView comment;
        private final ImageView praise;
        private final TextView praise_num;
        private final ImageView reward;
        private final TextView reward_num;
        private final ImageView transmit;
        private final LinearLayout linear_content;

        public TwoViewHolder(View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            nackname = itemView.findViewById(R.id.nackname);
            time = itemView.findViewById(R.id.time);
            source = itemView.findViewById(R.id.source);
            content = itemView.findViewById(R.id.content);
            coverImg = itemView.findViewById(R.id.coverImg);
            tPhoto = itemView.findViewById(R.id.tPhoto);
            tRealname = itemView.findViewById(R.id.tRealname);
            tIntro = itemView.findViewById(R.id.tIntro);
            tou_btn = itemView.findViewById(R.id.tou_btn);
            comment = itemView.findViewById(R.id.comment);
            praise = itemView.findViewById(R.id.praise);
            praise_num = itemView.findViewById(R.id.praise_num);
            reward = itemView.findViewById(R.id.reward);
            reward_num = itemView.findViewById(R.id.reward_num);
            transmit = itemView.findViewById(R.id.transmit);
            linear_content=itemView.findViewById(R.id.linear_content);
        }
    }

}
