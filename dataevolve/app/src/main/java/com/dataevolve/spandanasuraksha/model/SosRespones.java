package com.dataevolve.spandanasuraksha.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SosRespones {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("resultString")
    @Expose
    private String resultString;
    @SerializedName("errorMsg")
    @Expose
    private Object errorMsg;
    @SerializedName("payLoad")
    @Expose
    private String payLoad;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }

}
