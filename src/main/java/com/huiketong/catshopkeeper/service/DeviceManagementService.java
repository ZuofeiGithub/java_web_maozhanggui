package com.huiketong.catshopkeeper.service;

import com.huiketong.catshopkeeper.entity.DeviceManagement;
import com.huiketong.catshopkeeper.util.AjaxReturn;

import java.util.List;

public interface DeviceManagementService {

    //分页获取设备列表
    List<DeviceManagement> getDeviceLimit(Integer pageSize, Integer limit, Integer businessId);

    //获取设备总数
    int getCount( Integer businessId);

    //删除设备
    AjaxReturn deleteById( Integer id);

    //添加设备
    AjaxReturn addDeviceManagement(DeviceManagement business);

    //修改设备
    AjaxReturn updateDeviceManagement(DeviceManagement business);

}
