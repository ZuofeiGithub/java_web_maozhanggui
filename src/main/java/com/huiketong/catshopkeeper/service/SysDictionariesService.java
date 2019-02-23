package com.huiketong.catshopkeeper.service;

import com.huiketong.catshopkeeper.entity.SysDictionaries;

import java.util.List;

public interface SysDictionariesService {

    //获取系统字典列表
    List<SysDictionaries> getSysDictionariesListByParentId( Integer parentId);
}
