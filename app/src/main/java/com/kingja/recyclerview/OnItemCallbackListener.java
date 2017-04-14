package com.kingja.recyclerview;

/**
 * Description:TODO
 * Create Time:2017/4/14 15:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface OnItemCallbackListener {
    /**
     * @param fromPosition 起始位置
     * @param toPosition   移动的位置
     */
    void onMove(int fromPosition, int toPosition);

    void onSwipe(int position);
}
