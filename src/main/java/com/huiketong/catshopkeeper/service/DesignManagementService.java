package com.huiketong.catshopkeeper.service;

import com.huiketong.catshopkeeper.entity.DesignManagement;
import com.huiketong.catshopkeeper.util.AjaxReturn;

import java.util.List;
import java.util.Map;

public interface DesignManagementService {

    //分页获取设计图列表
    List<Map<String,Object>> getDesignLimit(Integer pageSize, Integer limit, Integer businessId);

    //获取设计图总数
    int getCount( Integer businessId);

    //删除设计图
    AjaxReturn deleteById(Integer id);

    //添加设计图
    AjaxReturn addDesignManagement(DesignManagement business);

    //修改设计图
    AjaxReturn updateDesignManagement(DesignManagement business);
}
