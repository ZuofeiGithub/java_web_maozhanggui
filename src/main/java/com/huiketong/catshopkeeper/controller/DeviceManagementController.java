package com.huiketong.catshopkeeper.controller;

import com.huiketong.catshopkeeper.entity.DeviceManagement;
import com.huiketong.catshopkeeper.entity.UserInfo;
import com.huiketong.catshopkeeper.service.DeviceManagementService;
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
@RequestMapping(value = "/deviceManagement")
public class DeviceManagementController {

    public  final  static Logger logger= LoggerFactory.getLogger(DeviceManagementController.class);

    @Autowired
    DeviceManagementService deviceManagementService;
    /**
     * 设备管理页面
     */
    @RequestMapping(value = "/deviceHtml")
    public String loginHtml() {

        return "deviceManagement";
    }

    /**
     * 设备列表
     */
    @RequestMapping(value = "/deviceList")
    @ResponseBody
    public Map<String,Object> deviceList(HttpServletRequest httpServletRequest,Integer page, Integer limit ) {
        HttpSession session=httpServletRequest.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        Map<String,Object> map= new HashMap<String,Object>();
        try {
            List<DeviceManagement> deviceManagementList=deviceManagementService.getDeviceLimit((page-1)*limit,limit,userInfo.getBusinessid());
            map = new HashMap<String,Object>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", deviceManagementService.getCount(userInfo.getBusinessid()));
            map.put("data", deviceManagementList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }

        return map;
    }

    /**
     * 删除设备
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteDeviceById")
    @ResponseBody
    public AjaxReturn deleteDeviceById(HttpServletRequest request, Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            ajaxReturn =deviceManagementService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("删除设备失败!");
        }
        return  ajaxReturn;

    }


    /**
     * 添加设备
     * @param request
     * @param devicecode
     * @param devicename
     * @param deviceaddress
     * @return
     */
    @RequestMapping(value = "/addDeviceManagement")
    @ResponseBody
    public AjaxReturn addBusiness(HttpServletRequest request, String devicecode,String devicename,String deviceaddress) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        HttpSession session=request.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        try {
            DeviceManagement business=new DeviceManagement();
            business.setDeviceaddress(deviceaddress);
            business.setDevicecode(devicecode);
            business.setDevicename(devicename);
            business.setBusinessid(userInfo.getBusinessid());
            ajaxReturn = deviceManagementService.addDeviceManagement(business);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("添加设备失败!");
        }
        return  ajaxReturn;

    }

    /**
     * 修改设备
     * @param request
     * @param devicecode
     * @param devicename
     * @param deviceaddress
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateBusiness")
    @ResponseBody
    public AjaxReturn updateBusiness(HttpServletRequest request, String devicecode,String devicename,String deviceaddress,Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            DeviceManagement business=new DeviceManagement();
            business.setDeviceaddress(deviceaddress);
            business.setDevicecode(devicecode);
            business.setDevicename(devicename);
            business.setId(id);
            ajaxReturn = deviceManagementService.updateDeviceManagement(business);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("修改设备失败!");
        }
        return  ajaxReturn;

    }

}
