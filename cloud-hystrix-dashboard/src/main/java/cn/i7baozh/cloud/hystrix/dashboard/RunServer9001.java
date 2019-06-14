package cn.i7baozh.cloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "cn.i7baozh.cloud.hystrix.dashboard")
public class RunServer9001 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer9001.class);
        springApplication.setAdditionalProfiles("9001");
        springApplication.run(args);
    }
}
