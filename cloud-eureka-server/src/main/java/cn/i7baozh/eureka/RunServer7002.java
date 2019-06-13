package cn.i7baozh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@EnableEurekaServer
@SpringBootApplication(scanBasePackages = "cn.i7baozh.eureka")
public class RunServer7002 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer7002.class);
        springApplication.setAdditionalProfiles("7002");
        springApplication.run(args);
    }
}
