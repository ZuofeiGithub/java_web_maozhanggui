package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.DesignManagement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DesignManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignManagement record);

    int insertSelective(DesignManagement record);

    DesignManagement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignManagement record);

    int updateByPrimaryKey(DesignManagement record);

    //分页获取设计图列表
    List<Map<String,Object>> getDesignLimit(@Param("pageSize") Integer pageSize, @Param("limit") Integer limit, @Param("businessId") Integer businessId);

    //获取设计图总数
    int getCount(@Param("businessId")Integer businessId);

    //删除设计图
    int deleteById(@Param("id") Integer id);


    //添加设计图
    int addDesignManagement(DesignManagement business);

    //修改设计图
    int updateDesignManagement(DesignManagement business);

}