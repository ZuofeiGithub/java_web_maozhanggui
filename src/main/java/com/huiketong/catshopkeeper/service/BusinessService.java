package com.huiketong.catshopkeeper.service;

import com.huiketong.catshopkeeper.entity.Business;
import com.huiketong.catshopkeeper.util.AjaxReturn;

import java.util.List;

public interface BusinessService {

    //分页获取商家列表
    List<Business> getBusinessLimit( Integer pageSize, Integer limit);

    //获取商家总数
    int getCount();

    //删除商家
    AjaxReturn deleteById( Integer id);

    //添加商家
    AjaxReturn addBusiness(Business business);

    //修改商家
    AjaxReturn updateBusiness(Business business);

    //获取所有商家列表(下拉框)
    List<Business> getBusinessList();

}
