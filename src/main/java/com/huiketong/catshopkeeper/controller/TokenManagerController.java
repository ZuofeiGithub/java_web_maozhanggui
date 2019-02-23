package com.huiketong.catshopkeeper.controller;

import com.huiketong.catshopkeeper.entity.TokenManager;
import com.huiketong.catshopkeeper.service.TokenManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TokenManager)表控制层
 *
 * @author makejava
 * @since 2019-02-14 12:39:15
 */
@RestController
@RequestMapping("tokenManager")
public class TokenManagerController {
    /**
     * 服务对象
     */
    @Resource
    private TokenManagerService tokenManagerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TokenManager selectOne(Integer id) {
        return this.tokenManagerService.queryById(id);
    }

}