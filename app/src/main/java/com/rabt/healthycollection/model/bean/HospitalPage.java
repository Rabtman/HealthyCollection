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
    private int total;
    @SerializedName("ret_code")
    private String code;
    private boolean flag;
    private String remark;
    private int page;
    private String msg;
    private List<HospitalInfo> hospitalList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
        private String id;
        private String tsks;
        private String bus;
        private String cityName;
        private String keshi;
        private String provinceName;
        private String addr;
        private String zzjb;
        private String hosName;
        private String info;
        private String img;

        public HospitalInfo() {
        }

        protected HospitalInfo(Parcel in) {
            this.id = in.readString();
            this.tsks = in.readString();
            this.bus = in.readString();
            this.cityName = in.readString();
            this.keshi = in.readString();
            this.provinceName = in.readString();
            this.addr = in.readString();
            this.zzjb = in.readString();
            this.hosName = in.readString();
            this.info = in.readString();
            this.img = in.readString();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTsks() {
            return tsks;
        }

        public void setTsks(String tsks) {
            this.tsks = tsks;
        }

        public String getBus() {
            return bus;
        }

        public void setBus(String bus) {
            this.bus = bus;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getKeshi() {
            return keshi;
        }

        public void setKeshi(String keshi) {
            this.keshi = keshi;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getZzjb() {
            return zzjb;
        }

        public void setZzjb(String zzjb) {
            this.zzjb = zzjb;
        }

        public String getHosName() {
            return hosName;
        }

        public void setHosName(String hosName) {
            this.hosName = hosName;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.tsks);
            dest.writeString(this.bus);
            dest.writeString(this.cityName);
            dest.writeString(this.keshi);
            dest.writeString(this.provinceName);
            dest.writeString(this.addr);
            dest.writeString(this.zzjb);
            dest.writeString(this.hosName);
            dest.writeString(this.info);
            dest.writeString(this.img);
        }

        @Override
        public String toString() {
            return "HospitalInfo{" +
                    "id='" + id + '\'' +
                    ", tsks='" + tsks + '\'' +
                    ", bus='" + bus + '\'' +
                    ", cityName='" + cityName + '\'' +
                    ", keshi='" + keshi + '\'' +
                    ", provinceName='" + provinceName + '\'' +
                    ", addr='" + addr + '\'' +
                    ", zzjb='" + zzjb + '\'' +
                    ", hosName='" + hosName + '\'' +
                    ", info='" + info + '\'' +
                    ", img='" + img + '\'' +
                    '}';
        }
    }
}
