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
public class RunServer7001 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer7001.class);
        springApplication.setAdditionalProfiles("7001");
        springApplication.run(args);
    }
}
