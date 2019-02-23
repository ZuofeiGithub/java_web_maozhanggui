package com.huiketong.catshopkeeper.service.impl;

import com.huiketong.catshopkeeper.entity.TokenManager;
import com.huiketong.catshopkeeper.dao.TokenManagerDao;
import com.huiketong.catshopkeeper.service.TokenManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TokenManager)表服务实现类
 *
 * @author makejava
 * @since 2019-02-14 12:39:14
 */
@Service("tokenManagerService")
public class TokenManagerServiceImpl implements TokenManagerService {
    @Resource
    private TokenManagerDao tokenManagerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TokenManager queryById(Integer id) {
        return this.tokenManagerDao.queryById(id);
    }

    @Override
    public TokenManager queryByDeviceId(String deviceId) {
        return this.tokenManagerDao.queryByDeviceId(deviceId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TokenManager> queryAllByLimit(int offset, int limit) {
        return this.tokenManagerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tokenManager 实例对象
     * @return 实例对象
     */
    @Override
    public TokenManager insert(TokenManager tokenManager) {
        this.tokenManagerDao.insert(tokenManager);
        return tokenManager;
    }

    /**
     * 修改数据
     *
     * @param tokenManager 实例对象
     * @return 实例对象
     */
    @Override
    public TokenManager update(TokenManager tokenManager) {
        this.tokenManagerDao.update(tokenManager);
        return this.queryByDeviceId(tokenManager.getDeviceId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tokenManagerDao.deleteById(id) > 0;
    }
}