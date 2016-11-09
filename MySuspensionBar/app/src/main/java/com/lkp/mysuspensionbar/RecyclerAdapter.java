package com.lkp.mysuspensionbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



/**
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.itemView.getContext())
                .load(getAvatarResId(position))
                .centerInside()
                .fit()
                .into(holder.mIvAvatar);

        Picasso.with(holder.itemView.getContext())
                .load(getContentResId(position))
                .centerInside()
                .fit()
                .into(holder.mIvContent);

        holder.mTvNickname.setText("star " + position);
    }

    private int getAvatarResId(int position) {
                return R.drawable.earth;
    }

    private int getContentResId(int position) {
        switch (position % 4) {
            case 0:
                return R.drawable.picture1;
            case 1:
                return R.drawable.picture2;
            case 2:
                return R.drawable.picture3;
            case 3:
                return R.drawable.picture4;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvAvatar;
        ImageView mIvContent;
        TextView mTvNickname;

        public ViewHolder(View itemView) {
            super(itemView);
            mIvAvatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
            mIvContent = (ImageView) itemView.findViewById(R.id.iv_content);
            mTvNickname = (TextView) itemView.findViewById(R.id.tv_nickname);
        }

    }
}

