package cn.i7baozh.cloud.provider.controller;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.discovery.DiscoveryClientRouteLocator;
import org.springframework.web.bind.annotation.*;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/view/{id}")
    public DeptBean getById(@PathVariable Long id) {
        System.out.println("测试客户端负载均衡: " + id);
        return deptService.getById(id);
    }

    @PostMapping("/update")
    public DeptBean getById(Long id, String name) {
        DeptBean deptBean = deptService.updateById(id, name);

        return deptBean;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery() {
        return discoveryClient;
    }

    @GetMapping("/delete/{id}")
    public Integer deleteById(@PathVariable Long id) {
        return deptService.deleteById(id);
    }
}
