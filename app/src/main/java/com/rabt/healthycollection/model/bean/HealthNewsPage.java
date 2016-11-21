package com.rabt.healthycollection.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/21
 */

public class HealthNewsPage {
    @SerializedName("ret_code")
    private int code;
    @SerializedName("pagebean")
    private Page page;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public static class Page {
        private int allPages;
        private int currentPage;
        private int allNum;
        private int maxResult;
        private List<Content> contentlist;

        public int getAllPages() {
            return allPages;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public List<Content> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<Content> contentlist) {
            this.contentlist = contentlist;
        }

        public static class Content {
            /**
             * id : 044629
             * author : 科教网
             * title : 世界肝炎日：预防肝炎，立即行动
             * time : 2015-07-28 17:05:24
             * tname : 疾病资讯
             * img : http://img1.gtimg.com/health/pics/hv1/37/205/1889/122884537.jpg
             * tid : 2
             */

            private String id;
            private String author;
            private String title;
            private String time;
            private String tname;
            private String img;
            private String tid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }
        }
    }
}
