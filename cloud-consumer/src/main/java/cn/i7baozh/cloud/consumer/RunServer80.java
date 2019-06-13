package cn.i7baozh.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@SpringBootApplication(scanBasePackages = "cn.i7baozh.cloud.consumer")
@EnableEurekaClient
public class RunServer80 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer80.class);
        SpringApplication.run(RunServer80.class, args);
    }
}
