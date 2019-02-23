package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

   //根据用户id获取用户菜单权限
    List<SysMenu> getSysMenuListByUserId(@Param("userId") Integer userId);
}