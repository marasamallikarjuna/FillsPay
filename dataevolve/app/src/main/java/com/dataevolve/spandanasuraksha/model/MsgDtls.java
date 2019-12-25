package com.dataevolve.spandanasuraksha.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MsgDtls {

    @SerializedName("usr_ph_nm")
    @Expose
    private String usrPhNm;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("otp_no")
    @Expose
    private Integer otpNo;
    @SerializedName("text")
    @Expose
    private String text;

    public String getUsrPhNm() {
        return usrPhNm;
    }

    public void setUsrPhNm(String usrPhNm) {
        this.usrPhNm = usrPhNm;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getOtpNo() {
        return otpNo;
    }

    public void setOtpNo(Integer otpNo) {
        this.otpNo = otpNo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}