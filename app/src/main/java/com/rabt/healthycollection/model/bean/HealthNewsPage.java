package com.rabt.healthycollection.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/21
 */

public class HealthNewsPage {
    private boolean status;
    private int total;
    @SerializedName("tngou")
    private List<HealthNews> healthNewsList;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<HealthNews> getHealthNewsList() {
        return healthNewsList;
    }

    public void setHealthNewsList(List<HealthNews> healthNewsList) {
        this.healthNewsList = healthNewsList;
    }

    public static class HealthNews {
        private int count;
        private String description;
        private int fcount;
        private int id;
        private String img;
        private int infoclass;
        private String keywords;
        private int rcount;
        private long time;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getInfoclass() {
            return infoclass;
        }

        public void setInfoclass(int infoclass) {
            this.infoclass = infoclass;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
