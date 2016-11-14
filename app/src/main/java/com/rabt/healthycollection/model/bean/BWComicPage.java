package com.rabt.healthycollection.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public class BWComicPage {
    @SerializedName("pagebean")
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public static class Page {
        @SerializedName("hasMorePage")
        private boolean hasMore;
        private int currentPage;
        private String maxResult;

        private List<ComicItem> contentlist;

        public boolean isHasMore() {
            return hasMore;
        }

        public void setHasMore(boolean hasMore) {
            this.hasMore = hasMore;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public String getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(String maxResult) {
            this.maxResult = maxResult;
        }

        public List<ComicItem> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<ComicItem> contentlist) {
            this.contentlist = contentlist;
        }

        public static class ComicItem {
            private String id;
            private String time;
            private String title;
            private String link;
            private List<String> thumbnailList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public List<String> getThumbnailList() {
                return thumbnailList;
            }

            public void setThumbnailList(List<String> thumbnailList) {
                this.thumbnailList = thumbnailList;
            }
        }
    }
}
