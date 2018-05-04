package com.example.lou.thewishofthestar.model;

/**
 * Created by vicoltree on 17/10/27.
 */

public class AppTokenModel {

    /**
     * code : 0
     * data : {}
     * message : string
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {

        private String apptoken;

        public String getApptoken() {
            return apptoken;
        }

        public void setApptoken(String apptoken) {
            this.apptoken = apptoken;
        }
    }
}
