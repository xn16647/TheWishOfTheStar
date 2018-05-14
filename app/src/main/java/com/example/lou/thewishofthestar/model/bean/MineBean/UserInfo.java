package com.example.lou.thewishofthestar.model.bean.MineBean;

public class UserInfo {

    /**
     * code : 0
     * message : 成功
     * data : {"id":998,"page":1,"rows":20,"pid":0,"salt":"9356480365049098","nickname":"阿三","realname":null,"photo":"http://qiniu.5roo.com/null","images":null,"intro":null,"details":null,"mobile":"15901412395","psw":"49733d256863740e8590e43e46305f70054b89500c69008a","email":null,"sex":0,"birthday":null,"country":null,"province":null,"city":null,"area":null,"address":null,"userType":1,"post":null,"college":null,"major":null,"skilled":null,"ip":null,"lastTime":1525999053000,"createDate":1525959537000,"idcardFront":null,"idcardBack":null,"teachCard":null,"isauth":0,"identityAuthTime":null,"pushHome":0,"sortTime":1525999005000,"openid":null,"unionid":"","qqUid":"","sinaUid":"","status":0,"topTime":null,"videoPath":null,"beanAmount":0,"openidMini":null,"openidWx":null,"flag":null,"weight":0}
     */

    private int code;
    private String message;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }
}
