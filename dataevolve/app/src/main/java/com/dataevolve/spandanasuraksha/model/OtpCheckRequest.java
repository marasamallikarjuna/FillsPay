package com.dataevolve.spandanasuraksha.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpCheckRequest {

    @SerializedName("otp_no")
    @Expose
    private String otpNo;
    @SerializedName("usr_ph_nm")
    @Expose
    private String usrPhNm;

    public String getOtpNo() {
        return otpNo;
    }

    public void setOtpNo(String otpNo) {
        this.otpNo = otpNo;
    }

    public String getUsrPhNm() {
        return usrPhNm;
    }

    public void setUsrPhNm(String usrPhNm) {
        this.usrPhNm = usrPhNm;
    }

}
