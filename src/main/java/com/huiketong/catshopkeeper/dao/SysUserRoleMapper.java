package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}