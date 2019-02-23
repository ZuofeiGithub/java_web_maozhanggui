package com.huiketong.catshopkeeper.service.impl;

import com.huiketong.catshopkeeper.dao.BusinessMapper;
import com.huiketong.catshopkeeper.entity.Business;
import com.huiketong.catshopkeeper.service.BusinessService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;

    @Override
    public List<Business> getBusinessLimit(Integer pageSize, Integer limit) {

        List<Business> businessList =businessMapper.getBusinessLimit(pageSize, limit);

        return businessList;
    }

    @Override
    public int getCount() {

        int count=businessMapper.getCount();
        return count;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn deleteById(Integer id) {

         AjaxReturn ajaxReturn=new AjaxReturn();

         int num=businessMapper.deleteById(id);
         if(num>0){
             ajaxReturn.setCode(200);
             ajaxReturn.setMessage("删除商家成功!");
         }else{
             ajaxReturn.setCode(400);
             ajaxReturn.setMessage("删除商家失败!");
         }

        return ajaxReturn;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn addBusiness(Business business) {

        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=businessMapper.addBusiness(business);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("添加商家成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("添加商家失败!");
        }

        return ajaxReturn;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn updateBusiness(Business business) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=businessMapper.updateBusiness(business);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("修改商家成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("修改商家失败!");
        }

        return ajaxReturn;
    }

    @Override
    public List<Business> getBusinessList() {
        List<Business> businessList =businessMapper.getBusinessList();
        return businessList;
    }
}
