package com.kingja.recyclerview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        return R.layout.item_shop_device;
    }

    @Override
    protected void bindHolder(ViewHolder baseHolder, Data bean, final int position) {
        final GiftViewHolder holder = (GiftViewHolder) baseHolder;
//        holder.tv_msg.setText(bean.getMsg());
//        holder.iv_icon.setBackgroundResource(bean.getResId());
        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "删除:" + position, Toast.LENGTH_SHORT).show();
            }
        });
//        holder.ll_root.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "position:" + position, Toast.LENGTH_SHORT).show();
//            }
//        });
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
        public TextView tv_delete;
        public LinearLayout ll_root;

        public GiftViewHolder(View itemView) {
            super(itemView);
//            tv_msg = (TextView) itemView.findViewById(R.id.tv_msg);
//            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_delete = (TextView) itemView.findViewById(R.id.tv_delete);
            tv_delete = (TextView) itemView.findViewById(R.id.tv_delete);
            ll_root = (LinearLayout) itemView.findViewById(R.id.ll_root);
        }
    }
}
