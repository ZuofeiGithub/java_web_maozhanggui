package com.huiketong.catshopkeeper.service;

import com.huiketong.catshopkeeper.entity.TokenManager;
import jdk.nashorn.internal.parser.Token;

import java.util.List;

/**
 * (TokenManager)表服务接口
 *
 * @author makejava
 * @since 2019-02-14 12:39:12
 */
public interface TokenManagerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TokenManager queryById(Integer id);


    TokenManager queryByDeviceId(String deviceId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TokenManager> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tokenManager 实例对象
     * @return 实例对象
     */
    TokenManager insert(TokenManager tokenManager);

    /**
     * 修改数据
     *
     * @param tokenManager 实例对象
     * @return 实例对象
     */
    TokenManager update(TokenManager tokenManager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}