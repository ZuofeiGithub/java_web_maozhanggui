package com.huiketong.catshopkeeper.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TokenManager)实体类
 *
 * @author makejava
 * @since 2019-02-14 12:39:09
 */
public class TokenManager implements Serializable {
    private static final long serialVersionUID = -88447038970459734L;
    
    private Integer id;
    
    private String accessToken;
    
    private Date updateTime;
    
    private String deviceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}