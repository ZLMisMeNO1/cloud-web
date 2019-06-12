package cn.i7baozh.cloud.provider.dao;

import cn.i7baozh.cloud.api.bean.DeptBean;
import org.apache.ibatis.annotations.Param;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
public interface DeptMapper {

    /**
     * 根据id获取
     * @param id
     * @return
     */
    DeptBean findById(Long id);

    /**
     * 更新
     * @param id
     * @param name
     * @return
     */
    int updateById(@Param("id") Long id, @Param("name") String name);

    /**
     *  删除
     * @param id
     * @return
     */
    int deleteById(Long id);

}
