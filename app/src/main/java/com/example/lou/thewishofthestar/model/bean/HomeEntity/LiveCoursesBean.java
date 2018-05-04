package com.example.lou.thewishofthestar.model.bean.HomeEntity;

public class LiveCoursesBean {
    /**
     * coverImg : http://qiniu.5roo.com/49a61e62-b049-49b2-83ae-52388f0c0353.jpg
     * endDate : 1523281176000
     * collegeIds : 4
     * groupid : null
     * photo : http://qiniu.5roo.com/806d2c15-cef8-411f-8ead-2822c3581787.jpg
     * title : 第一节  剖析影视表演的特点
     * type : 讲堂
     * userId : 262
     * realname : 李苒苒
     * majorIds : 6
     * price : 9.9
     * nickname : 李苒苒
     * id : 77
     * userType : 4
     * pushDate : 1523343743000
     * startDate : 1523281174000
     * liveStatus : 2
     */

    private String coverImg;
    private long endDate;
    private String collegeIds;
    private Object groupid;
    private String photo;
    private String title;
    private String type;
    private int userId;
    private String realname;
    private String majorIds;
    private double price;
    private String nickname;
    private int id;
    private int userType;
    private long pushDate;
    private long startDate;
    private int liveStatus;

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getCollegeIds() {
        return collegeIds;
    }

    public void setCollegeIds(String collegeIds) {
        this.collegeIds = collegeIds;
    }

    public Object getGroupid() {
        return groupid;
    }

    public void setGroupid(Object groupid) {
        this.groupid = groupid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMajorIds() {
        return majorIds;
    }

    public void setMajorIds(String majorIds) {
        this.majorIds = majorIds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public long getPushDate() {
        return pushDate;
    }

    public void setPushDate(long pushDate) {
        this.pushDate = pushDate;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public int getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(int liveStatus) {
        this.liveStatus = liveStatus;
    }
}
