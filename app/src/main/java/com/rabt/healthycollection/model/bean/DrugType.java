package com.rabt.healthycollection.model.bean;

/**
 * author: Rabtman
 * date: 2016-12-01
 * description:
 */

public class DrugType {
    private String id;
    private String type;

    public DrugType(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
