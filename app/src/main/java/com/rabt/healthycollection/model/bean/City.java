package com.rabt.healthycollection.model.bean;

import me.yokeyword.indexablerv.IndexableEntity;

/**
 * @author zjm
 * @Description:
 * @date 2016/12/5
 */

public class City implements IndexableEntity {

    private String name;
    private String pinyin;

    @Override
    public String getFieldIndexBy() {
        return name;  // return 你需要根据该属性排序的field
    }

    @Override
    public void setFieldIndexBy(String indexByField) {
        this.name = indexByField; // 同上
    }

    @Override
    public void setFieldPinyinIndexBy(String pinyin) {
        this.pinyin = pinyin; // 保存排序field的拼音,在执行比如搜索等功能时有用 （若不需要，空实现该方法即可）
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
