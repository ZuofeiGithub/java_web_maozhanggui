package com.huiketong.catshopkeeper.service.impl;

import com.huiketong.catshopkeeper.dao.CustomerMapper;
import com.huiketong.catshopkeeper.entity.Customer;
import com.huiketong.catshopkeeper.service.CustomerService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<Customer> getCustomerLimit(Integer pageSize, Integer limit, Integer businessId) {
        List<Customer> customerList=customerMapper.getCustomerLimit(pageSize, limit, businessId);
        return customerList;
    }

    @Override
    public int getCount(Integer businessId) {

        int  count=customerMapper.getCount(businessId);
        return count;
    }

    @Override
    public AjaxReturn deleteById(Integer id) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=customerMapper.deleteById(id);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("删除客户成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("删除客户失败!");
        }

        return ajaxReturn;
    }

    @Override
    public AjaxReturn addCustomer(Customer customer) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=customerMapper.addCustomer(customer);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("添加客户成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("添加客户失败!");
        }

        return ajaxReturn;
    }

    @Override
    public AjaxReturn updateCustomer(Customer customer) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=customerMapper.updateCustomer(customer);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("修改客户成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("修改客户失败!");
        }

        return ajaxReturn;
    }
}
