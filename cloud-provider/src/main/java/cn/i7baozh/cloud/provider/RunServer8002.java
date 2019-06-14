package cn.i7baozh.cloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
@SpringBootApplication(scanBasePackages = "cn.i7baozh.cloud.provider")
public class RunServer8002 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer8002.class);
        springApplication.setAdditionalProfiles("8002");
        springApplication.run( args);
    }
}
