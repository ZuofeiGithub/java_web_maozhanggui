package com.huiketong.catshopkeeper.dao;

import com.huiketong.catshopkeeper.entity.TokenManager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TokenManager)表数据库访问层
 *
 * @author makejava
 * @since 2019-02-14 12:39:10
 */
public interface TokenManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TokenManager queryById(Integer id);

    TokenManager queryByDeviceId(String deviceId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TokenManager> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tokenManager 实例对象
     * @return 对象列表
     */
    List<TokenManager> queryAll(TokenManager tokenManager);

    /**
     * 新增数据
     *
     * @param tokenManager 实例对象
     * @return 影响行数
     */
    int insert(TokenManager tokenManager);

    /**
     * 修改数据
     *
     * @param tokenManager 实例对象
     * @return 影响行数
     */
    int update(TokenManager tokenManager);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}