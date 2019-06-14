package cn.i7baozh.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
// @SpringBootApplication 不能扫描只扫描cn.i7baozh.cloud.consumer 这个包，也要扫描cn.i7baozh.cloud.api 不然会
    // 加载不了class cn.i7baozh.cloud.api.hystrix.factory.DeptHystixFactory 这个类
    //报错信息为 No fallbackFactory instance of type class cn.i7baozh.cloud.api.hystrix.factory.DeptHystixFactory found for feign client DEPT-PROVIDER
@SpringBootApplication(scanBasePackages = {"cn.i7baozh.cloud.consumer","cn.i7baozh.cloud.api"})
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.i7baozh.cloud.api")
public class RunServer6001 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer6001.class);
        springApplication.setAdditionalProfiles("6001");
        springApplication.run(args);
    }
}
