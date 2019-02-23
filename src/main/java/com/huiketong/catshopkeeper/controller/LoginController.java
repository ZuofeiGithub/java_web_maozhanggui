package com.huiketong.catshopkeeper.controller;

import com.huiketong.catshopkeeper.entity.SysMenu;
import com.huiketong.catshopkeeper.entity.UserInfo;
import com.huiketong.catshopkeeper.service.UserInfoService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import com.huiketong.catshopkeeper.util.PwdMd5Util;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    public  final  static Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserInfoService userInfoService;


    /**
     * 登录页面
     */
    @RequestMapping(value = "/loginHtml")
    public String loginHtml() {

        return "login";
    }

    /**
     * home首页
     */
    @RequestMapping(value = "/homeHtml")
    public String homeHtml() {
        return "home";
    }

    /**
     * 退出操作
     * @return
     */
    @RequestMapping(value = "/logOutHtml")
    public String logOutHtml(HttpServletRequest httpServletRequest) {
        HttpSession session=httpServletRequest.getSession();
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 主页index
     */
    @RequestMapping(value = "/indexHtml")
    public String indexHtml(HttpServletRequest httpServletRequest, Model  map) {
        HttpSession session=httpServletRequest.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        try {
            List<SysMenu> sysMenuList= userInfoService.getSysMenuListByUserId(userInfo.getId());
            List<SysMenu> sysMenuListM=new ArrayList<SysMenu>();//主目录
            List<SysMenu> sysMenuListC=new ArrayList<SysMenu>();//子菜单
            for(int i=0;i<sysMenuList.size();i++){
                if(sysMenuList.get(i).getParentId()==0&&StringUtils.isNotEmpty(sysMenuList.get(i).getUrl())){
                    sysMenuListM.add(sysMenuList.get(i));
                }else{
                    sysMenuListC.add(sysMenuList.get(i));
                }

            }
           map.addAttribute("sysMenuListM",sysMenuListM);
           map.addAttribute("sysMenuListC",sysMenuListC);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
        return "index";
    }


    /**
     *用户登录
     * @param httpServletRequest
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/loginCheck")
    @ResponseBody
    public AjaxReturn loginCheck(HttpServletRequest httpServletRequest,String username,String pwd) {
        String md5Pwd= PwdMd5Util.md5Hex(pwd);
       // System.out.println(md5Pwd+"---");
        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            ajaxReturn=userInfoService.loginCheck(httpServletRequest,username,md5Pwd);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("系统异常!");
        }
        return ajaxReturn;
    }


    /**
     * 获取用户属性
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public Map<String,String> getUserInfo(HttpServletRequest httpServletRequest) {

        HttpSession session=httpServletRequest.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        Map<String,String> map= new HashMap<String,String>();
        try {
            map = userInfoService.getUserInfo(userInfo.getId());
            map.put("code","200");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            map.put("code","400");
        }

        return map;
    }

}
