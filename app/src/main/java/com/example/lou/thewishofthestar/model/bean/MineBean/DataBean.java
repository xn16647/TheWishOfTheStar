package com.example.lou.thewishofthestar.model.bean.MineBean;

public class DataBean {

    /**
     * nickname : 赵虎
     * mobile : 17610827898
     * photo : null
     * id : 983
     * token : eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiI1czQ1bWsiLCJzdWIiOiI5ODMiLCJleHAiOjE1MjY1MzkyOTEsImlhdCI6MTUyNTkzNDQ5MX0.PrNyx-HySQUy3HEF0SI4TJN3n26wHdvu98A8Jgbv_J8RhvhR6tSodWvpDFGdESO2vPsZvPy_L1wp3JlcPSYpzQ
     */

    private String nickname;
    private String mobile;
    private Object photo;
    private int id;
    private String token;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
