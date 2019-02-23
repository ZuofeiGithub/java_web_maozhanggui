package com.huiketong.catshopkeeper.service.impl;

import com.huiketong.catshopkeeper.dao.DeviceManagementMapper;
import com.huiketong.catshopkeeper.entity.DeviceManagement;
import com.huiketong.catshopkeeper.service.DeviceManagementService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceManagementServiceImpl implements DeviceManagementService {

    @Autowired
    DeviceManagementMapper deviceManagementMapper;

    @Override
    public List<DeviceManagement> getDeviceLimit(Integer pageSize, Integer limit,Integer businessId) {

        List<DeviceManagement> deviceManagementList=deviceManagementMapper.getDeviceLimit(pageSize, limit,businessId);
        return deviceManagementList;
    }

    @Override
    public int getCount(Integer businessId) {

        int count=deviceManagementMapper.getCount(businessId);
        return count;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn deleteById(Integer id) {

        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=deviceManagementMapper.deleteById(id);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("删除设备成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("删除设备失败!");
        }

        return ajaxReturn;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn addDeviceManagement(DeviceManagement business) {

        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=deviceManagementMapper.addDeviceManagement(business);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("添加设备成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("添加设备失败!");
        }

        return ajaxReturn;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn updateDeviceManagement(DeviceManagement business) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=deviceManagementMapper.updateDeviceManagement(business);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("修改设备成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("修改设备失败!");
        }

        return ajaxReturn;
    }
}
