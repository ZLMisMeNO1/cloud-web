package cn.i7baozh.cloud.provider.service;

import cn.i7baozh.cloud.api.bean.DeptBean;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface DeptService {

    /**
     *
     * @param id
     * @return
     */
    DeptBean getById(Long id);

    /**
     * 更新
     * @param id
     * @param name
     * @return
     */
    DeptBean updateById(Long id, String name);

    /**
     *  删除
     * @param id
     * @return
     */
    Integer deleteById(Long id);
}
