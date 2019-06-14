package cn.i7baozh.cloud.provider.controller;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.provider.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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


    /**
     * 使用HystrixCommand注解的方式 缺点是硬编码，
     * 且每个方法都要提供一个代替方法，使得代码量大。
     * 还有一点是，如果服务不可用了（断电、完全崩溃）时，客户端无法知道，还在等待服务端响应，一直等待就会造成拥堵，或集群的雪崩。
     * <p>
     * 可以使用api端加入HystrixFactory的方式
     *
     * @param id
     * @return
     * @see
     */
    @GetMapping("/view/{id}")
    @HystrixCommand(fallbackMethod = "getByIdHystrix")
    public DeptBean getById(@PathVariable Long id) {
        System.out.println("测试客户端负载均衡: " + id);
        DeptBean bean = deptService.getById(id);

        //如果为空则抛异常，测试服务熔断
        if (bean == null) {
            throw new RuntimeException("出错了");

        }
        return bean;
    }

    /**
     * 熔断的代替方法
     * @param id
     * @return
     */
    public DeptBean getByIdHystrix(@PathVariable Long id) {
        return new DeptBean().setId(10000L).setDeptName("测试服务熔断");
    }

    @PostMapping("/update")
    public DeptBean getById(Long id, String name) {
        DeptBean deptBean = deptService.updateById(id, name);

        return deptBean;
    }

    @GetMapping("/view2/{id}")
    public DeptBean getById2(@PathVariable Long id) {
        System.out.println("测试降级: " + id);
        DeptBean bean = deptService.getById(id);

        //如果为空则抛异常，测试服务熔断
        if (bean == null) {
            throw new RuntimeException("出错了");

        }
        return bean;
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
