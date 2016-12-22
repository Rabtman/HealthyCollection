package com.rabt.healthycollection.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author zjm
 * @Description:
 * @date 2016/12/5
 */

public class HospitalPage {
    private boolean status;
    private int total;
    @SerializedName("tngou")
    private List<HospitalInfo> hospitalList;

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

    public List<HospitalInfo> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<HospitalInfo> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public static class HospitalInfo implements Parcelable {
        public static final Creator<HospitalInfo> CREATOR = new Creator<HospitalInfo>() {
            @Override
            public HospitalInfo createFromParcel(Parcel source) {
                return new HospitalInfo(source);
            }

            @Override
            public HospitalInfo[] newArray(int size) {
                return new HospitalInfo[size];
            }
        };
        private String address;
        private int area;
        private int count;
        private String fax;
        private int fcount;
        private String gobus;
        private int id;
        private String img;
        private String level;
        private String mail;
        private String message;
        private String mtype;
        private String name;
        private String nature;
        private int rcount;
        private String tel;
        private String url;
        @SerializedName("x")
        private double longitude;
        @SerializedName("y")
        private double latitude;
        private String zipcode;

        public HospitalInfo() {
        }

        protected HospitalInfo(Parcel in) {
            this.address = in.readString();
            this.area = in.readInt();
            this.count = in.readInt();
            this.fax = in.readString();
            this.fcount = in.readInt();
            this.gobus = in.readString();
            this.id = in.readInt();
            this.img = in.readString();
            this.level = in.readString();
            this.mail = in.readString();
            this.message = in.readString();
            this.mtype = in.readString();
            this.name = in.readString();
            this.nature = in.readString();
            this.rcount = in.readInt();
            this.tel = in.readString();
            this.url = in.readString();
            this.latitude = in.readDouble();
            this.longitude = in.readDouble();
            this.zipcode = in.readString();
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public String getGobus() {
            return gobus;
        }

        public void setGobus(String gobus) {
            this.gobus = gobus;
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

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMtype() {
            return mtype;
        }

        public void setMtype(String mtype) {
            this.mtype = mtype;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNature() {
            return nature;
        }

        public void setNature(String nature) {
            this.nature = nature;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.address);
            dest.writeInt(this.area);
            dest.writeInt(this.count);
            dest.writeString(this.fax);
            dest.writeInt(this.fcount);
            dest.writeString(this.gobus);
            dest.writeInt(this.id);
            dest.writeString(this.img);
            dest.writeString(this.level);
            dest.writeString(this.mail);
            dest.writeString(this.message);
            dest.writeString(this.mtype);
            dest.writeString(this.name);
            dest.writeString(this.nature);
            dest.writeInt(this.rcount);
            dest.writeString(this.tel);
            dest.writeString(this.url);
            dest.writeDouble(this.latitude);
            dest.writeDouble(this.longitude);
            dest.writeString(this.zipcode);
        }
    }
}
