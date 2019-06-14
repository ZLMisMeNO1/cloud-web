package cn.i7baozh.cloud.api.hystrix.factory;

import cn.i7baozh.cloud.api.bean.DeptBean;
import cn.i7baozh.cloud.api.service.DeptApiService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Title: DeptApiService 降级工厂类，特别注意 @Component 注解不要忘了
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Component
public class DeptHystixFactory implements FallbackFactory<DeptApiService> {
    @Override
    public DeptApiService create(Throwable throwable) {
        DeptApiService hystrixService = new DeptApiService() {
            @Override
            public DeptBean getById(Long id) {
                return new DeptBean().setId(2000L).setDeptName("这个是使用了降级来处理的");
            }
        };
        return hystrixService;
    }
}
