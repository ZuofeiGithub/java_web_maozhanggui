package com.huiketong.catshopkeeper.controller;

import com.huiketong.catshopkeeper.entity.UserInfo;
import com.huiketong.catshopkeeper.service.UserInfoService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import com.huiketong.catshopkeeper.util.PwdMd5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    public  final  static Logger logger= LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;


    /**
     * 后台用户账号页面
     */
    @RequestMapping(value = "/userInfoHtml")
    public String loginHtml() {

        return "userInfo";
    }



    /**
     * 后台账号列表
     */
    @RequestMapping(value = "/userInfoList")
    @ResponseBody
    public Map<String,Object> userInfoList(HttpServletRequest httpServletRequest, Integer page, Integer limit ) {
        Map<String,Object> map= null;
        try {
            List<Map<String,String>> deviceManagementList=userInfoService.getAllUserList((page-1)*limit,limit);
            map = new HashMap<String,Object>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count",userInfoService.getCount());
            map.put("data", deviceManagementList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }

        return map;
    }


    /**
     * 添加后台账号
     * @param request
     * @param username
     * @param password
     * @param newPassword
     * @param business
     * @param imgurl
     * @return
     */
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public AjaxReturn addBusiness(HttpServletRequest request, String username, String password, String newPassword,Integer business, String imgurl) {
        AjaxReturn ajaxReturn= new AjaxReturn();
        if(!password.equals(newPassword)){
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("密码不一致!");
            return  ajaxReturn;
        }
        try {
            UserInfo userInfo=new UserInfo();
            userInfo.setBusinessid(business);
            userInfo.setImgurl(imgurl);
            userInfo.setPassword(PwdMd5Util.md5Hex(password));
            userInfo.setUsername(username);
            ajaxReturn = userInfoService.addUser(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("添加用户失败!");
        }
        return  ajaxReturn;

    }

    /**
     * 删除后台账号
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUserById")
    @ResponseBody
    public AjaxReturn deleteUserById(HttpServletRequest request, Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            ajaxReturn = userInfoService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("删除商家失败!");
        }
        return  ajaxReturn;

    }



}
