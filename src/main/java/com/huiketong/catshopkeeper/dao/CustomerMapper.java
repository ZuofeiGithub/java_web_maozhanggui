package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    //分页获取客户列表
    List<Customer> getCustomerLimit(@Param("pageSize") Integer pageSize, @Param("limit") Integer limit, @Param("businessId") Integer businessId);

    //获取客户总数
    int getCount(@Param("businessId")Integer businessId);


    //删除客户
    int deleteById(@Param("id") Integer id);


    //添加客户
    int addCustomer(Customer customer);

    //修改客户
    int updateCustomer(Customer customer);
}