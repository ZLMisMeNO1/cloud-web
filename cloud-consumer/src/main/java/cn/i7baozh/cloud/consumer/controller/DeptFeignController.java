package cn.i7baozh.cloud.consumer.controller;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.api.service.DeptApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: 使用Feign的方式使用服务
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@RequestMapping("/dept2")
public class DeptFeignController {

    @Autowired
    private DeptApiService deptApiService;

    @GetMapping("/view/{id}")
    public DeptBean getById(@PathVariable Long id) {

        return deptApiService.getById(id);
    }
}
