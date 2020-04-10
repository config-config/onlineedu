package cn.losemen.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/1 - 17:21
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"cn.losemen.edu","cn.losemen.common"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
