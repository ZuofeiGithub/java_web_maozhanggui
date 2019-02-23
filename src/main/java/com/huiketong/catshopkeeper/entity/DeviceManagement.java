package com.huiketong.catshopkeeper.entity;

/**
 * 设备
 */
public class DeviceManagement {
    private Integer id;

    private String devicecode;

    private String devicename;

    private Integer devicestatus;

    private String deviceaddress;

    private String deviceLongitude;

    private String deviceDimension;

    private Integer businessid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode == null ? null : devicecode.trim();
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename == null ? null : devicename.trim();
    }

    public Integer getDevicestatus() {
        return devicestatus;
    }

    public void setDevicestatus(Integer devicestatus) {
        this.devicestatus = devicestatus;
    }

    public String getDeviceaddress() {
        return deviceaddress;
    }

    public void setDeviceaddress(String deviceaddress) {
        this.deviceaddress = deviceaddress == null ? null : deviceaddress.trim();
    }

    public String getDeviceLongitude() {
        return deviceLongitude;
    }

    public void setDeviceLongitude(String deviceLongitude) {
        this.deviceLongitude = deviceLongitude == null ? null : deviceLongitude.trim();
    }

    public String getDeviceDimension() {
        return deviceDimension;
    }

    public void setDeviceDimension(String deviceDimension) {
        this.deviceDimension = deviceDimension == null ? null : deviceDimension.trim();
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }
}