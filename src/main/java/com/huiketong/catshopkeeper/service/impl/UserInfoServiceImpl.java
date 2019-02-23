package com.huiketong.catshopkeeper.service.impl;

import com.huiketong.catshopkeeper.dao.SysMenuMapper;
import com.huiketong.catshopkeeper.dao.UserInfoMapper;
import com.huiketong.catshopkeeper.entity.SysMenu;
import com.huiketong.catshopkeeper.entity.UserInfo;
import com.huiketong.catshopkeeper.service.UserInfoService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    SysMenuMapper sysMenuMapper;


    /**
     * 用户登录
     * @param httpServletRequest
     * @param username
     * @param pwd
     * @return
     */
    @Override
    public AjaxReturn loginCheck(HttpServletRequest httpServletRequest,String username, String pwd) {

        AjaxReturn  ajaxReturn=new AjaxReturn();
        HttpSession session=httpServletRequest.getSession();
        UserInfo userInfo=userInfoMapper.loginCheck(username,pwd);
        if(userInfo==null){
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("用户名或密码错误!");
        }else{
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("登陆成功!");
            session.setAttribute("user",userInfo);
            session.setMaxInactiveInterval(1800);
        }
        return ajaxReturn;
    }

    /**
     * 获取用户权限菜单
     * @param userId
     * @return
     */
    @Override
    public  List<SysMenu> getSysMenuListByUserId(Integer userId) {

        List<SysMenu> sysMenuList=sysMenuMapper.getSysMenuListByUserId(userId);

        return sysMenuList;
    }

    @Override
    public List<Map<String, String>> getAllUserList(Integer pageSize, Integer limit) {
        List<Map<String, String>> mapList=userInfoMapper.getAllUserList(pageSize, limit);
        return mapList;
    }

    @Override
    public int getCount() {
        int count=userInfoMapper.getCount();
        return count;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn addUser(UserInfo record) {
        AjaxReturn ajaxReturn=new AjaxReturn();

        int num=userInfoMapper.addUser(record);

        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("添加用户成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("添加用户失败!");
        }

        return ajaxReturn;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,timeout=30)
    public AjaxReturn deleteById(Integer id) {
        AjaxReturn ajaxReturn=new AjaxReturn();
        int num=userInfoMapper.deleteById(id);
        if(num>0){
            ajaxReturn.setCode(200);
            ajaxReturn.setMessage("删除用户成功!");
        }else{
            ajaxReturn.setCode(400);
            ajaxReturn.setMessage("删除用户失败!");
        }

        return ajaxReturn;
    }

    @Override
    public Map<String, String> getUserInfo(Integer id) {

        Map<String,String> map=userInfoMapper.getUserInfo(id);
        return map;
    }


}
