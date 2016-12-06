package com.rabt.healthycollection.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description: 药品信息集合
 */

public class DrugInfoPage {
    private boolean status;
    private int total;
    @SerializedName("tngou")
    private List<DrugInfo> drugInfoList;

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

    public List<DrugInfo> getDrugInfoList() {
        return drugInfoList;
    }

    public void setDrugInfoList(List<DrugInfo> drugInfoList) {
        this.drugInfoList = drugInfoList;
    }

    public static class DrugInfo implements Parcelable {
        public static final Creator<DrugInfo> CREATOR = new Creator<DrugInfo>() {
            @Override
            public DrugInfo createFromParcel(Parcel source) {
                return new DrugInfo(source);
            }

            @Override
            public DrugInfo[] newArray(int size) {
                return new DrugInfo[size];
            }
        };
        private int count;
        private String description;
        private int fcount;
        private int id;
        private String img;
        private String keywords;
        private String message;
        private String name;
        private int price;
        private int rcount;
        private String tag;
        private String type;

        public DrugInfo() {
        }

        protected DrugInfo(Parcel in) {
            this.count = in.readInt();
            this.description = in.readString();
            this.fcount = in.readInt();
            this.id = in.readInt();
            this.img = in.readString();
            this.keywords = in.readString();
            this.message = in.readString();
            this.name = in.readString();
            this.price = in.readInt();
            this.rcount = in.readInt();
            this.tag = in.readString();
            this.type = in.readString();
        }

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

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "DrugInfo{" +
                    "count=" + count +
                    ", description='" + description + '\'' +
                    ", fcount=" + fcount +
                    ", id=" + id +
                    ", img='" + img + '\'' +
                    ", keywords='" + keywords + '\'' +
                    ", message='" + message + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", rcount=" + rcount +
                    ", tag='" + tag + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.count);
            dest.writeString(this.description);
            dest.writeInt(this.fcount);
            dest.writeInt(this.id);
            dest.writeString(this.img);
            dest.writeString(this.keywords);
            dest.writeString(this.message);
            dest.writeString(this.name);
            dest.writeInt(this.price);
            dest.writeInt(this.rcount);
            dest.writeString(this.tag);
            dest.writeString(this.type);
        }
    }
}
