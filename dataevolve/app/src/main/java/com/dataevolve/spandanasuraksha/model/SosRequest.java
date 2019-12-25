package com.dataevolve.spandanasuraksha.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SosRequest{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("incidentId")
    @Expose
    private String incidentId;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("victimName")
    @Expose
    private String victimName;
    @SerializedName("victimAddress")
    @Expose
    private String victimAddress;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("eventDesc")
    @Expose
    private String eventDesc;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("gpsPacketTime")
    @Expose
    private String gpsPacketTime;
    @SerializedName("incidentLocation")
    @Expose
    private String incidentLocation;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("state")
    @Expose
    private String state;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public String getVictimAddress() {
        return victimAddress;
    }

    public void setVictimAddress(String victimAddress) {
        this.victimAddress = victimAddress;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGpsPacketTime() {
        return gpsPacketTime;
    }

    public void setGpsPacketTime(String gpsPacketTime) {
        this.gpsPacketTime = gpsPacketTime;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}