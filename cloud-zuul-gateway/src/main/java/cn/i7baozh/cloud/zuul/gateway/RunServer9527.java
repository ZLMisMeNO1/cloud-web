package cn.i7baozh.cloud.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@EnableZuulProxy
@SpringBootApplication(scanBasePackages = "cn.i7baozh.cloud.zuul.gateway")
public class RunServer9527 {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RunServer9527.class);
        springApplication.setAdditionalProfiles("9527");
        springApplication.run(args);
    }
}
