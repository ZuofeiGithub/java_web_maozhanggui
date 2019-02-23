package com.huiketong.catshopkeeper.controller;

import com.huiketong.catshopkeeper.entity.SysDictionaries;
import com.huiketong.catshopkeeper.service.SysDictionariesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/sysDictionaries")
public class SysDictionariesController {

    public  final  static Logger logger= LoggerFactory.getLogger(SysDictionariesController.class);

    @Autowired
    SysDictionariesService sysDictionariesService;

    /**
     * 获取字典列表
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/sysDictionariesList")
    @ResponseBody
    public  List<SysDictionaries> sysDictionariesList(Integer parentId) {

        List<SysDictionaries> deviceManagementList= null;
        try {
            deviceManagementList = sysDictionariesService.getSysDictionariesListByParentId(parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceManagementList;
    }

}
