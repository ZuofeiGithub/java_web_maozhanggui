package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.DeviceManagement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceManagementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceManagement record);

    int insertSelective(DeviceManagement record);

    DeviceManagement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceManagement record);

    int updateByPrimaryKey(DeviceManagement record);

    //分页获取设备列表
    List<DeviceManagement> getDeviceLimit(@Param("pageSize") Integer pageSize, @Param("limit") Integer limit,@Param("businessId") Integer businessId);

    //获取设备总数
    int getCount(@Param("businessId")Integer businessId);

    //删除设备
    int deleteById(@Param("id") Integer id);

    //添加设备
    int addDeviceManagement(DeviceManagement business);

    //修改设备
    int updateDeviceManagement(DeviceManagement business);
}