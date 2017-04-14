package com.kingja.recyclerview;

/**
 * Description:TODO
 * Create Time:2017/4/14 15:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Data {
    public Data(String msg, int resId) {
        this.msg = msg;
        this.resId = resId;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    private int resId;
}
