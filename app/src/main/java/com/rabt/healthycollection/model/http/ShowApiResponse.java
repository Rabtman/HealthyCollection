package com.rabt.healthycollection.model.http;


import com.google.gson.annotations.SerializedName;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description: ShowApi统一返回体
 */

public class ShowApiResponse<T> {

    @SerializedName("showapi_res_code")
    private int code;
    @SerializedName("showapi_res_error")
    private String error;
    @SerializedName("showapi_res_body")
    private T body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
