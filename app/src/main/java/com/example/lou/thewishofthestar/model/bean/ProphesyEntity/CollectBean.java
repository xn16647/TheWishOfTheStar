package com.example.lou.thewishofthestar.model.bean.ProphesyEntity;

/**
 * Created by 1
 * on 2018/5/15.
 * at 北京
 */

public class CollectBean {

    /**
     * code : 0
     * message : 成功
     * data : {}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
