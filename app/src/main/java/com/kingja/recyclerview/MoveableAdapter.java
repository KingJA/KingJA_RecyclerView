package com.kingja.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingja.recyclerviewhelper.BaseRvAdaper;
import com.kingja.recyclerviewhelper.RecyclerViewHelper;

import java.util.Collections;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2016/8/16 13:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class MoveableAdapter extends BaseRvAdaper<Data> implements RecyclerViewHelper.OnItemCallback {


    public MoveableAdapter(Context context, List<Data> list) {
        super(context, list);
    }

    @Override
    protected ViewHolder createViewHolder(View v) {
        return new GiftViewHolder(v);
    }

    @Override
    protected int getItemView() {
        return R.layout.item_moveable;
    }

    @Override
    protected void bindHolder(ViewHolder baseHolder, Data bean, final int position) {
        final GiftViewHolder holder = (GiftViewHolder) baseHolder;
        holder.tv_msg.setText(bean.getMsg());
        holder.iv_icon.setBackgroundResource(bean.getResId());
    }

    public void onMove(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onSwipe(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }


    class GiftViewHolder extends ViewHolder {
        public TextView tv_msg;
        public ImageView iv_icon;

        public GiftViewHolder(View itemView) {
            super(itemView);
            tv_msg = (TextView) itemView.findViewById(R.id.tv_msg);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }
}
