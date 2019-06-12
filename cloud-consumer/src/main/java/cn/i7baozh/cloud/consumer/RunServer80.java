package cn.i7baozh.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@SpringBootApplication(scanBasePackages = "cn.i7baozh.cloud.consumer")
public class RunServer80 {

    public static void main(String[] args) {
        SpringApplication.run(RunServer80.class, args);
    }
}
