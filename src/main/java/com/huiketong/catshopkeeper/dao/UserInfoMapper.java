package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    //用户登录
    UserInfo loginCheck(@Param("username")String username, @Param("pwd")String pwd);

    //获取所用用户
    List<Map<String,String>> getAllUserList(@Param("pageSize") Integer pageSize, @Param("limit") Integer limit);

    //获取用户总数
    int getCount();
    //添加用户
    int addUser(UserInfo record);

    //删除商家
     int deleteById(@Param("id") Integer id);

    //获取用户属性
     Map<String,String>  getUserInfo(@Param("id") Integer id);
}