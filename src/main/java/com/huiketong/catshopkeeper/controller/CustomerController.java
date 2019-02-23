package com.huiketong.catshopkeeper.controller;

import com.huiketong.catshopkeeper.entity.Customer;
import com.huiketong.catshopkeeper.entity.UserInfo;
import com.huiketong.catshopkeeper.service.CustomerService;
import com.huiketong.catshopkeeper.util.AjaxReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    public  final  static Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService  customerService;

    /**
     * 客户管理页面
     */
    @RequestMapping(value = "/customerHtml")
    public String customerHtml() {

        return "customer";
    }

    /**
     * 客户管理列表
     */
    @RequestMapping(value = "/customerList")
    @ResponseBody
    public Map<String,Object> designList(HttpServletRequest httpServletRequest, Integer page, Integer limit ) {
        HttpSession session=httpServletRequest.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        Map<String,Object> map= new HashMap<String,Object>();
        try {
            List<Customer> deviceManagementList=customerService.getCustomerLimit((page-1)*limit,limit,userInfo.getBusinessid());
            map = new HashMap<String,Object>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", customerService.getCount(userInfo.getBusinessid()));
            map.put("data", deviceManagementList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }

        return map;
    }

    /**
     * 添加客户
     * @param request
     * @param customerName
     * @param customerPhone
     * @param customerAddress
     * @return
     */
    @RequestMapping(value = "/addCustomer")
    @ResponseBody
    public AjaxReturn addCustomer(HttpServletRequest request,String customerName,String customerPhone,String customerAddress) {
        AjaxReturn ajaxReturn= new AjaxReturn();
        HttpSession session=request.getSession();
        UserInfo userInfo= (UserInfo) session.getAttribute("user");
        try {
            Customer customer=new Customer();
            customer.setAddtime(new Date());
            customer.setBusinessid(userInfo.getBusinessid());
            customer.setCustomerAddress(customerAddress);
            customer.setCustomerName(customerName);
            customer.setCustomerPhone(customerPhone);
            ajaxReturn =customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("添加用户失败!");
        }
        return  ajaxReturn;

    }

    /**
     * 修改客户
     * @param request
     * @param customerName
     * @param customerPhone
     * @param customerAddress
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateCustomer")
    @ResponseBody
    public AjaxReturn updateCustomer(HttpServletRequest request, String customerName,String customerPhone,String customerAddress,Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            Customer customer=new Customer();
            customer.setAddtime(new Date());
            customer.setCustomerAddress(customerAddress);
            customer.setCustomerName(customerName);
            customer.setCustomerPhone(customerPhone);
            customer.setId(id);
            ajaxReturn =customerService.updateCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("修改客户失败!");
        }
        return  ajaxReturn;

    }

    /**
     * 删除客户
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteCustomerById")
    @ResponseBody
    public AjaxReturn deleteCustomerById(HttpServletRequest request, Integer id) {

        AjaxReturn ajaxReturn= new AjaxReturn();
        try {
            ajaxReturn =customerService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            ajaxReturn.setCode(500);
            ajaxReturn.setMessage("删除客户失败!");
        }
        return  ajaxReturn;

    }
}
