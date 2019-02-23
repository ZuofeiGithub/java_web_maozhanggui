package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.SysDictionaries;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDictionariesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictionaries record);

    int insertSelective(SysDictionaries record);

    SysDictionaries selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictionaries record);

    int updateByPrimaryKey(SysDictionaries record);
    //获取系统字典列表
    List<SysDictionaries> getSysDictionariesListByParentId(@Param("parentId") Integer parentId);
}