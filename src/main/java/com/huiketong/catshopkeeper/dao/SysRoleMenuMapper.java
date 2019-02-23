package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.SysRoleMenu;

public interface SysRoleMenuMapper {
    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);
}