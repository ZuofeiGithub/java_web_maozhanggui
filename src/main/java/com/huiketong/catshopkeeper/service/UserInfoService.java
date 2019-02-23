package com.huiketong.catshopkeeper.service;


import com.huiketong.catshopkeeper.entity.SysMenu;
import com.huiketong.catshopkeeper.entity.UserInfo;
import com.huiketong.catshopkeeper.util.AjaxReturn;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserInfoService {

    //用户登录
    AjaxReturn loginCheck(HttpServletRequest httpServletRequest,String username, String pwd);


    //根据用户id获取用户菜单权限
    List<SysMenu> getSysMenuListByUserId( Integer userId);

    //获取所用用户
    List<Map<String,String>> getAllUserList( Integer pageSize, Integer limit);

    //获取用户总数
    int getCount();

    //添加用户
    AjaxReturn addUser(UserInfo record);

    //删除商家
    AjaxReturn deleteById( Integer id);

    //获取用户属性
    Map<String,String>  getUserInfo( Integer id);

}
