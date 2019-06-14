package cn.i7baozh.cloud.provider.service.impl;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.provider.dao.DeptMapper;
import cn.i7baozh.cloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@CacheConfig(cacheNames = "dept")
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Cacheable(key = "'dept_' + #id")
    @Override
    public DeptBean getById(Long id) {
        return deptMapper.findById(id);
    }

    @CachePut(key = "'dept_' + #id")
    @Override
    public DeptBean updateById(Long id, String name) {
        deptMapper.updateById(id, name);
        return deptMapper.findById(id);
    }

    @CacheEvict(key = "'dept_' + #id")
    @Override
    public Integer deleteById(Long id) {
        return deptMapper.deleteById(id);
    }
}
