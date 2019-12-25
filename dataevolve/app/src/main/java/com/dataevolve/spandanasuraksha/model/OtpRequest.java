package com.dataevolve.spandanasuraksha.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpRequest {

    @SerializedName("usr_ph_nm")
    @Expose
    private String usrPhNm;

    public String getUsrPhNm() {
        return usrPhNm;
    }

    public void setUsrPhNm(String usrPhNm) {
        this.usrPhNm = usrPhNm;
    }

}