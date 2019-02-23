package com.huiketong.catshopkeeper.service.impl;

import com.huiketong.catshopkeeper.dao.DesignManagementMapper;
import com.huiketong.catshopkeeper.entity.DesignManagement;
import com.huiketong.catshopkeeper.service.DesignManagementService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DesignManagementServiceImpl implements DesignManagementService {

    @Autowired
    DesignManagementMapper designManagementMapper;

    @Override
    public  List<Map<String,Object>> getDesignLimit(Integer pageSize, Integer limit, Integer businessId) {

        List<Map<String,Object>> designManagementList=designManagementMapper.getDesignLimit(pageSize, limit,businessId);
        return designManagementList;
    }

    @Override
    public int getCount(Integer businessId) {

        int count=designManagementMapper.getCount(businessId);
        return count;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn deleteById(Integer id) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=designManagementMapper.deleteById(id);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("删除设计图成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("删除设计图失败!");
        }

        return ajaxReturn;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn addDesignManagement(DesignManagement business) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=designManagementMapper.addDesignManagement(business);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("添加设计图成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("添加设计图失败!");
        }

        return ajaxReturn;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn updateDesignManagement(DesignManagement business) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=designManagementMapper.updateDesignManagement(business);
        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("修改设计图成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("修改设计图失败!");
        }

        return ajaxReturn;
    }
}
