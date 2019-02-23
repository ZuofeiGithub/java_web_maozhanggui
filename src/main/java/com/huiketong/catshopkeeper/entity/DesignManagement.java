package com.huiketong.catshopkeeper.entity;

/**
 * 设计图
 */
public class DesignManagement {
    private Integer id;

    private Integer designArea;

    private Integer designStyle;

    private Integer designBudget;

    private String designUrl;

    private Integer businessid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDesignArea() {
        return designArea;
    }

    public void setDesignArea(Integer designArea) {
        this.designArea = designArea;
    }

    public Integer getDesignStyle() {
        return designStyle;
    }

    public void setDesignStyle(Integer designStyle) {
        this.designStyle = designStyle;
    }

    public Integer getDesignBudget() {
        return designBudget;
    }

    public void setDesignBudget(Integer designBudget) {
        this.designBudget = designBudget;
    }

    public String getDesignUrl() {
        return designUrl;
    }

    public void setDesignUrl(String designUrl) {
        this.designUrl = designUrl == null ? null : designUrl.trim();
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }
}