package com.kingja.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Description:TODO
 * Create Time:2017/4/15 9:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class RecyclerViewHelper {
    private OnItemCallback onItemCallback;
    private ItemTouchHelper.Callback helperCallback;
    private boolean dragable;
    private boolean swipeable;
    private final ItemTouchHelper itemTouchHelper;
    private Context context;
    private LayoutHelper.LayoutStyle layoutStyle;
    private int dividerHeight;
    private int dividerColor;
    private int columns;

    public RecyclerViewHelper(Builder builder) {
        this.columns = builder.columns;
        this.dividerHeight = builder.dividerHeight;
        this.dividerColor = builder.dividerColor;
        this.context = builder.context;
        this.onItemCallback = builder.onItemCallback;
        this.layoutStyle = builder.layoutStyle;
        this.dragable = builder.dragable;
        this.swipeable = builder.swipeable;
        helperCallback = new SimpleItemTouchHelperCallback(onItemCallback, dragable, swipeable);
        itemTouchHelper = new ItemTouchHelper(helperCallback);
    }


    public void attachToRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            throw new IllegalArgumentException("The recyclerView attached can't be null");
        }
        if (onItemCallback instanceof RecyclerView.Adapter) {
            recyclerView.setAdapter((RecyclerView.Adapter) onItemCallback);
        }
        recyclerView.setLayoutManager(LayoutHelper.getLayoutManager(context, layoutStyle, columns));
        if (layoutStyle == layoutStyle.GRID) {
            recyclerView.addItemDecoration(new GridItemDecoration(
                    context, dividerHeight, dividerColor));
        } else {
            recyclerView.addItemDecoration(new ListItemDecoration(
                    context, layoutStyle, dividerHeight, dividerColor));
        }


        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    static class Builder {
        public Builder(Context context) {
            this.context = context;
        }

        private Context context;
        private int dividerHeight;
        private int dividerColor;
        private int columns = 2;
        private LayoutHelper.LayoutStyle layoutStyle;
        private OnItemCallback onItemCallback;
        private boolean dragable = true;
        private boolean swipeable = true;

        public Builder setCallbackAdapter(OnItemCallback onItemCallback) {
            this.onItemCallback = onItemCallback;
            return this;
        }

        public Builder setLayoutStyle(LayoutHelper.LayoutStyle layoutStyle) {
            this.layoutStyle = layoutStyle;
            return this;
        }

        public Builder setDragable(boolean dragable) {
            this.dragable = dragable;
            return this;
        }

        public Builder setSwipeable(boolean swipeable) {
            this.swipeable = swipeable;
            return this;
        }

        public Builder setDividerHeight(int dividerHeight) {
            this.dividerHeight = dividerHeight;
            return this;
        }

        public Builder setColumns(int columns) {
            this.columns = columns;
            return this;
        }

        public Builder setDividerColor(int dividerColor) {
            this.dividerColor = dividerColor;
            return this;
        }

        public RecyclerViewHelper build() {
            if (onItemCallback == null) {
                throw new IllegalArgumentException("A adapter that implements the OnItemCallback interface is " +
                        "required");
            }
            return new RecyclerViewHelper(this);
        }
    }

    interface OnItemCallback {
        void onMove(int fromPosition, int toPosition);

        void onSwipe(int position);
    }


}
