package com.rabt.healthycollection.model.bean;

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

    public static class HospitalInfo {
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
    }
}
