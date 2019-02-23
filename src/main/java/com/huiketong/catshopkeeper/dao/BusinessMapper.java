package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.Business;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);

    //分页获取商家列表
    List<Business> getBusinessLimit(@Param("pageSize") Integer pageSize,@Param("limit") Integer limit);

    //获取所有商家列表(下拉框)
    List<Business> getBusinessList();

    //获取商家总数
    int getCount();

    //删除商家
    int deleteById(@Param("id") Integer id);

    //添加商家
    int addBusiness(Business business);

   //修改商家
    int updateBusiness(Business business);
}