package com.huiketong.catshopkeeper.service;

import com.huiketong.catshopkeeper.entity.Customer;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerService {

    //分页获取设计图列表
    List<Customer> getCustomerLimit( Integer pageSize,  Integer limit, Integer businessId);

    //获取设计图总数
    int getCount(Integer businessId);

    //删除客户
    AjaxReturn deleteById(@Param("id") Integer id);

    //添加客户
    AjaxReturn addCustomer(Customer customer);

    //修改客户
    AjaxReturn updateCustomer(Customer customer);
}
