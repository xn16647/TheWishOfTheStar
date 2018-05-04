package com.example.lou.thewishofthestar.model.bean.HomeEntity;

import java.util.List;

public class DataBean {
    private List<LiveCoursesBean> liveCourses;
    private List<?> lives;
    private List<HomewoksBean> homewoks;
    private List<SystemAdsBean> systemAds;
    private List<UsersBean> users;

    public List<LiveCoursesBean> getLiveCourses() {
        return liveCourses;
    }

    public void setLiveCourses(List<LiveCoursesBean> liveCourses) {
        this.liveCourses = liveCourses;
    }

    public List<?> getLives() {
        return lives;
    }

    public void setLives(List<?> lives) {
        this.lives = lives;
    }

    public List<HomewoksBean> getHomewoks() {
        return homewoks;
    }

    public void setHomewoks(List<HomewoksBean> homewoks) {
        this.homewoks = homewoks;
    }

    public List<SystemAdsBean> getSystemAds() {
        return systemAds;
    }

    public void setSystemAds(List<SystemAdsBean> systemAds) {
        this.systemAds = systemAds;
    }

    public List<UsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<UsersBean> users) {
        this.users = users;
    }
}
