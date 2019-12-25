package com.dataevolve.spandanasuraksha.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @SerializedName("msg")
    @Expose
    private String msg;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}