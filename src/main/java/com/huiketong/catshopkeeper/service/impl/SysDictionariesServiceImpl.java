package com.huiketong.catshopkeeper.service.impl;

import com.huiketong.catshopkeeper.dao.SysDictionariesMapper;
import com.huiketong.catshopkeeper.entity.SysDictionaries;
import com.huiketong.catshopkeeper.service.SysDictionariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictionariesServiceImpl implements SysDictionariesService {

    @Autowired
    SysDictionariesMapper sysDictionariesMapper;

    @Override
    public List<SysDictionaries> getSysDictionariesListByParentId(Integer parentId) {
        List<SysDictionaries> deviceManagementList=sysDictionariesMapper.getSysDictionariesListByParentId(parentId);
        return deviceManagementList;
    }
}
