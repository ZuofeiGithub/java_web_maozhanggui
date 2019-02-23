package com.huiketong.catshopkeeper.controller;


import com.alibaba.fastjson.JSONObject;
import com.huiketong.catshopkeeper.entity.Business;
import com.huiketong.catshopkeeper.service.BusinessService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import com.huiketong.catshopkeeper.util.FileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "business")
public class BusinessController {

    public  final  static Logger logger= LoggerFactory.getLogger(BusinessController.class);


    @Autowired
    BusinessService businessService;

    /**
     * 商家页面
     */
    @RequestMapping(value = "/businessHtml")
    public String loginHtml() {

        return "business";
    }



    /**
     * 商家列表分页
     */
    @RequestMapping(value = "/businessList")
    @ResponseBody
    public  Map<String,Object> businessList(Integer page,Integer limit ) {
        Map<String,Object> map= null;
        try {
            List<Business> businessList=businessService.getBusinessLimit((page-1)*limit,limit);
            map = new HashMap<String,Object>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", businessService.getCount());
            map.put("data", businessList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }

        return map;
    }



    /**
     * 商家列表(下拉框)
     */
    @RequestMapping(value = "/businessListSelect")
    @ResponseBody
    public  List<Business> businessListSelect() {
        List<Business> businessList= null;
        try {
            businessList = businessService.getBusinessList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return businessList;
    }

    /**
     * 上传商家图片
     */
    @RequestMapping(value = "/uploadBusinessImg")
    @ResponseBody
    public String uploadBusinessImg(HttpServletRequest request, @RequestParam("file") MultipartFile file ) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        String fileUrl= null;
        try {
            fileUrl = FileUploadUtil.upload(request,file);
            map.put("code", 0);//0表示成功，1失败
            map.put("msg", "上传成功");//提示消息
            map1.put("src", fileUrl);//图片url
            map1.put("title", "成功");//图片名称，这个会显示在输入框里
            map.put("data", map1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    /**
     * 删除商家
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteBusinessById")
    @ResponseBody
    public AjaxReturn deleteBusinessById(HttpServletRequest request, Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            ajaxReturn = businessService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("删除商家失败!");
        }
        return  ajaxReturn;

    }

    /**
     * 添加商家
     * @param request
     * @param businessname
     * @param businessaddress
     * @param businessphone
     * @param imgurl
     * @return
     */
    @RequestMapping(value = "/addBusiness")
    @ResponseBody
    public AjaxReturn addBusiness(HttpServletRequest request, String businessname,String businessaddress,String businessphone,String imgurl) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            Business business=new Business();
            business.setBusinessaddress(businessaddress);
            business.setBusinessname(businessname);
            business.setImgurl(imgurl);
            business.setBusinessphone(businessphone);
            business.setCreationtime(new Date());
            ajaxReturn = businessService.addBusiness(business);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("添加商家失败!");
        }
        return  ajaxReturn;

    }

    /**
     * 修改商家
     * @param request
     * @param businessname
     * @param businessaddress
     * @param businessphone
     * @param imgurl
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateBusiness")
    @ResponseBody
    public AjaxReturn updateBusiness(HttpServletRequest request, String businessname,String businessaddress,String businessphone,String imgurl,Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            Business business=new Business();
            business.setBusinessaddress(businessaddress);
            business.setBusinessname(businessname);
            business.setImgurl(imgurl);
            business.setBusinessphone(businessphone);
            business.setCreationtime(new Date());
            business.setId(id);
            ajaxReturn = businessService.updateBusiness(business);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("修改商家失败!");
        }
        return  ajaxReturn;

    }
}
