package cn.losemen.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hz
 * @version 1.0
 * @Function
 * @date 2020/4/4 - 14:43
 */
@SpringBootApplication
@ComponentScan(basePackages={"cn.losemen.statistics","cn.losemen.common"})
@EnableEurekaClient
@EnableFeignClients
public class StatisticsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class, args);
    }
}
