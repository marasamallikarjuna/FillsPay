package com.dataevolve.spandanasuraksha.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("msg_dtls")
    @Expose
    private MsgDtls msgDtls;
    @SerializedName("msg_status")
    @Expose
    private Integer msgStatus;

    @SerializedName("profile_in")
    @Expose
    private Integer profileIn;

    public String getUsr_ph_nm() {
        return usr_ph_nm;
    }

    public void setUsr_ph_nm(String usr_ph_nm) {
        this.usr_ph_nm = usr_ph_nm;
    }

    @SerializedName("usr_ph_nm")
    @Expose
    private String usr_ph_nm;




    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @SerializedName("token")
    @Expose
    private String token;



    public Integer getProfileIn() {
        return profileIn;
    }

    public void setProfileIn(Integer profileIn) {
        this.profileIn = profileIn;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MsgDtls getMsgDtls() {
        return msgDtls;
    }

    public void setMsgDtls(MsgDtls msgDtls) {
        this.msgDtls = msgDtls;
    }

    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

}