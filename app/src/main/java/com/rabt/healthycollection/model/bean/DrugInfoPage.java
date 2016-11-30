package com.rabt.healthycollection.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description: 药品信息集合
 */

public class DrugInfoPage {
    @SerializedName("ret_code")
    private String code;
    private int page;
    @SerializedName("allResults")
    private int count;
    private String msg;
    private List<DrugInfo> drugList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DrugInfo> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<DrugInfo> drugList) {
        this.drugList = drugList;
    }

    public static class DrugInfo {
        private String zysx;
        private String blfy;
        private String zc;
        private String drugName;
        private String pzwh;
        private String yfyl;
        private String img;
        private String type;
        private String xz;
        private String zzjb;
        private String jj;
        private String id;
        private String price;
        private String manu;
        private String zxbz;
        private String yxq;
        private String ggxh;
        private String zycf;
        private String syz;
        private String ywxhzy;

        public String getZysx() {
            return zysx;
        }

        public void setZysx(String zysx) {
            this.zysx = zysx;
        }

        public String getBlfy() {
            return blfy;
        }

        public void setBlfy(String blfy) {
            this.blfy = blfy;
        }

        public String getZc() {
            return zc;
        }

        public void setZc(String zc) {
            this.zc = zc;
        }

        public String getDrugName() {
            return drugName;
        }

        public void setDrugName(String drugName) {
            this.drugName = drugName;
        }

        public String getPzwh() {
            return pzwh;
        }

        public void setPzwh(String pzwh) {
            this.pzwh = pzwh;
        }

        public String getYfyl() {
            return yfyl;
        }

        public void setYfyl(String yfyl) {
            this.yfyl = yfyl;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getXz() {
            return xz;
        }

        public void setXz(String xz) {
            this.xz = xz;
        }

        public String getZzjb() {
            return zzjb;
        }

        public void setZzjb(String zzjb) {
            this.zzjb = zzjb;
        }

        public String getJj() {
            return jj;
        }

        public void setJj(String jj) {
            this.jj = jj;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getManu() {
            return manu;
        }

        public void setManu(String manu) {
            this.manu = manu;
        }

        public String getZxbz() {
            return zxbz;
        }

        public void setZxbz(String zxbz) {
            this.zxbz = zxbz;
        }

        public String getYxq() {
            return yxq;
        }

        public void setYxq(String yxq) {
            this.yxq = yxq;
        }

        public String getGgxh() {
            return ggxh;
        }

        public void setGgxh(String ggxh) {
            this.ggxh = ggxh;
        }

        public String getZycf() {
            return zycf;
        }

        public void setZycf(String zycf) {
            this.zycf = zycf;
        }

        public String getSyz() {
            return syz;
        }

        public void setSyz(String syz) {
            this.syz = syz;
        }

        public String getYwxhzy() {
            return ywxhzy;
        }

        public void setYwxhzy(String ywxhzy) {
            this.ywxhzy = ywxhzy;
        }
    }
}
