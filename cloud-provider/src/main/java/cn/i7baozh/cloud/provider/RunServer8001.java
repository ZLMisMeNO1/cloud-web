package cn.i7baozh.cloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */

//开启缓存
@EnableCaching
// mybatis dao层扫描
@MapperScan(basePackages = "cn.i7baozh.cloud.provider.dao")
//将服务注册到 eureka 中
@EnableEurekaClient
@EnableDiscoveryClient
//@EnableHystrix
@SpringBootApplication(scanBasePackages = "cn.i7baozh.cloud.provider")
@EnableCircuitBreaker //对hystrix熔断机制的支持
public class RunServer8001 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer8001.class);
        springApplication.setAdditionalProfiles("8001");
        springApplication.run( args);
    }
}
