package cn.i7baozh.cloud.api.service;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.api.hystrix.factory.DeptHystixFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@FeignClient(name = "DEPT-PROVIDER",fallbackFactory = DeptHystixFactory.class)
public interface DeptApiService {

    /**
     * 注意这里有个大坑，如果 @PathVariable 中不使用value的话会报错
     * 报错信息：  PathVariable annotation was empty on param 0.
     * @param id
     * @return
     */
    @GetMapping("/dept/view2/{id}")
    DeptBean getById(@PathVariable(value = "id") Long id) ;

}
