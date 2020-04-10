package cn.losemen.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/4 - 14:03
 */
@SpringBootApplication
@ComponentScan(basePackages={"cn.losemen.ucenter","cn.losemen.common"})
@EnableEurekaClient
public class UcenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class, args);
    }
}