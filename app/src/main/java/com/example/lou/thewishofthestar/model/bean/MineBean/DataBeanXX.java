package com.example.lou.thewishofthestar.model.bean.MineBean;

import java.util.List;

public class DataBeanXX {
    /**
     * amount : 0
     * mobile : 17610710383
     * list : [{"id":1,"page":1,"rows":20,"amountAndroid":10,"priceAndroid":1,"amountIos":42,"priceIos":6},{"id":2,"page":1,"rows":20,"amountAndroid":200,"priceAndroid":20,"amountIos":210,"priceIos":30},{"id":3,"page":1,"rows":20,"amountAndroid":500,"priceAndroid":50,"amountIos":686,"priceIos":98},{"id":4,"page":1,"rows":20,"amountAndroid":1000,"priceAndroid":100,"amountIos":0,"priceIos":0},{"id":5,"page":1,"rows":20,"amountAndroid":2000,"priceAndroid":200,"amountIos":0,"priceIos":0},{"id":6,"page":1,"rows":20,"amountAndroid":5000,"priceAndroid":500,"amountIos":0,"priceIos":0},{"id":7,"page":1,"rows":20,"amountAndroid":10000,"priceAndroid":1000,"amountIos":0,"priceIos":0},{"id":8,"page":1,"rows":20,"amountAndroid":20000,"priceAndroid":2000,"amountIos":0,"priceIos":0}]
     */

    private int amount;
    private String mobile;
    private List<ListBean> list;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }
}
