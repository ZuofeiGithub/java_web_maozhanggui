package com.huiketong.catshopkeeper.controller;

import com.huiketong.catshopkeeper.entity.DesignManagement;
import com.huiketong.catshopkeeper.entity.UserInfo;
import com.huiketong.catshopkeeper.service.DesignManagementService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/designManagemen")
public class DesignManagementController {

    public  final  static Logger logger= LoggerFactory.getLogger(DesignManagementController.class);

    @Autowired
    DesignManagementService designManagementService;

    /**
     * 设计图管理页面
     */
    @RequestMapping(value = "/designHtml")
    public String loginHtml() {

        return "designManagement";
    }

    /**
     * 设计图列表
     */
    @RequestMapping(value = "/designList")
    @ResponseBody
    public Map<String,Object> designList(HttpServletRequest httpServletRequest,Integer page, Integer limit ) {
        HttpSession session=httpServletRequest.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        Map<String,Object> map= new HashMap<String,Object>();
        try {
            List<Map<String,Object>> deviceManagementList=designManagementService.getDesignLimit((page-1)*limit,limit,userInfo.getBusinessid());
            map = new HashMap<String,Object>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", designManagementService.getCount(userInfo.getBusinessid()));
            map.put("data", deviceManagementList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }

        return map;
    }


    /**
     * 删除设计图
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteDesignById")
    @ResponseBody
    public AjaxReturn deleteDesignById(HttpServletRequest request, Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            ajaxReturn =designManagementService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("删除设计图失败!");
        }
        return  ajaxReturn;

    }


    /**
     * 添加设计图
     * @param request
     * @param area
     * @param budget
     * @param style
     * @param imgurl
     * @return
     */
    @RequestMapping(value = "/addDesignManagemen")
    @ResponseBody
    public AjaxReturn addBusiness(HttpServletRequest request, Integer area,Integer budget,Integer style,String imgurl) {
        AjaxReturn ajaxReturn= new AjaxReturn();
        HttpSession session=request.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        try {
            DesignManagement business=new DesignManagement();
            business.setBusinessid(userInfo.getBusinessid());
            business.setDesignArea(area);
            business.setDesignBudget(budget);
            business.setDesignStyle(style);
            business.setDesignUrl(imgurl);
            ajaxReturn =designManagementService.addDesignManagement(business);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("添加设备失败!");
        }
        return  ajaxReturn;

    }

    /**
     * 修改设计图
     * @param request
     * @param area
     * @param budget
     * @param style
     * @param imgurl
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateDesignManagemen")
    @ResponseBody
    public AjaxReturn updateBusiness(HttpServletRequest request, Integer area,Integer budget,Integer style,String imgurl,Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            DesignManagement business=new DesignManagement();
            business.setId(id);
            business.setDesignArea(area);
            business.setDesignBudget(budget);
            business.setDesignStyle(style);
            business.setDesignUrl(imgurl);
            ajaxReturn =designManagementService.updateDesignManagement(business);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("修改设备失败!");
        }
        return  ajaxReturn;

    }
}
