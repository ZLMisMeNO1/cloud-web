package cn.i7baozh.cloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@EnableCaching
@MapperScan(basePackages = "cn.i7baozh.cloud.provider.dao")
@SpringBootApplication(scanBasePackages = "cn.i7baozh.cloud.provider")
public class RunServer8001 {

    public static void main(String[] args) {
        SpringApplication.run(RunServer8001.class, args);
    }
}
